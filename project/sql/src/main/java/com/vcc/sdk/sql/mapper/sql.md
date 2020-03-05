~~~ mapper
<select id="getById" parameterType="java.lang.Integer" resultMap="resultMap">
		select
		<include refid="columnList" />
		from ${tableName} 
		where cat_id = #{id}
	</select>
	<select id="getOne" parameterType="java.util.Map" resultMap="resultMap">
		select
		<if test="field == null">
			<include refid="columnList" />
		</if>
		<if test="field != null">
			${field}
		</if>
		from ${tableName} 
		<where>
			<foreach collection="condition" index="key" item="value">
				${value} ${key}
			</foreach>
		</where>
		limit 1;
	</select>
	<select id="getCount" parameterType="java.util.Map" resultType="java.lang.Integer">
		select
		count(cat_id)
		from ${tableName} 
		<where>
			<foreach collection="condition" index="key" item="value">
				${value} ${key}
			</foreach>
		</where>
	</select>
	<!-- 这部分为根据传递参数，自动生成SQL -->
	<select id="getList" parameterType="java.util.Map" resultMap="resultMap">
		select
		<if test="field == null">
			<include refid="columnList" />
		</if>
		<if test="field != null">
			${field}
		</if>
		from ${tableName} 
		<where>
			<foreach collection="condition" index="key" item="value">
				${value} ${key}
			</foreach>
		</where>
		<if test="order != null">
			order by ${order}
		</if>
		<if test="limit != 0">
			<if test="offset != 0">
				limit ${offset}, ${limit}
			</if>
			<if test="offset == 0">
				limit ${limit}
			</if>
		</if>
	</select>

	<update id="update"  parameterType="java.util.List" >
		<foreach collection="list" item="entity" index="index" separator=";">
		UPDATE ${tableName} SET 
		cat_user_id=#{entity.catUserId}, cat_menu_id=#{entity.catMenuId}, cat_note=#{entity.catNote}, cat_time=#{entity.catTime}, tb_status=#{entity.tbStatus}
		 WHERE 
		cat_id = #{entity.catId}

		</foreach>
	</update>
	<update id="updateByBatch" >
			UPDATE ${tableName} SET
				${field}
			<where>
				<foreach collection="condition" index="key" item="value">
					${value} ${key}
				</foreach>
			</where>
	</update>

~~~ 

~~~java
package com.plan.common;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

/** 
* 
* @author 吴彬 的  autoWeb 自动代码 网址  www.wubin9.com 
* @data 2019年01月19日 16:05:04  
* 此文件由 www.wubin9.com 网站的自动代码 autoWeb 自动生成。 
* 可以根据需求随意修改，如果需要帮助，请联系 吴彬 
* 联系方式：QQ 810978593  微信  wubin0830bingo 邮箱 wubin5922@dingtalk.com 
*/ 
public interface IOperations<T extends Serializable> {

	void insert(@Param("entity") final T entity, @Param("tableName") String tableName);

	int insertByBatch(@Param("list") List<T> list, @Param("tableName") String tableName);

	int update(@Param("list") List<T> list, @Param("tableName") String tableName);
	
	int updateByBatch(@Param("condition") LinkedHashMap<String, String> condition, @Param("field") String field, @Param("tableName") String tableName);

	T getById(@Param("id") final int id, @Param("tableName") String tableName);

	T getOne(@Param("condition") LinkedHashMap<String, String> condition, @Param("field") String field, @Param("tableName") String tableName);

	int getCount(@Param("condition") LinkedHashMap<String, String> condition, @Param("field") String field, @Param("tableName") String tableName);

	List<T> getList(@Param("condition") LinkedHashMap<String, String> condition, @Param("offset") int offset, @Param("limit") int limit, @Param("order") String order,
			@Param("field") String field, @Param("tableName") String tableName);

	// 以下方法特殊，为判断表是否存在，批量和创建表

	int existTable(@Param("tableName") String tableName);

	int createTable(@Param("tableName") String tableName);

}
~~~

~~~java
package com.plan.common;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
/** 
* 
* @author 吴彬 的  autoWeb 自动代码 网址  www.wubin9.com 
* @data 2019年01月19日 16:05:04  
* 此文件由 www.wubin9.com 网站的自动代码 autoWeb 自动生成。 
* 可以根据需求随意修改，如果需要帮助，请联系 吴彬 
* 联系方式：QQ 810978593  微信  wubin0830bingo 邮箱 wubin5922@dingtalk.com 
*/ 
public interface IServiceOperations<T extends Serializable> extends IOperations<T> {

	void setTableName(String tableName);
	
	void insert(final T entity);
	
	int insertByBatch(List<T> list);

	int update(List<T> list);
	
	int updateByBatch(LinkedHashMap<String, String> condition, String field);

	T getById(final int id);

	T getOne(LinkedHashMap<String, String> condition, String field);

	int getCount(LinkedHashMap<String, String> condition, String field);

	List<T> getList(int pageNo, int pageSize);

	List<T> getList(int pageNo, int pageSize, String order);

	List<T> getList(int pageNo, int pageSize, String order, String field);

	List<T> getList(LinkedHashMap<String, String> condition, int pageNo, int pageSize);

	List<T> getList(LinkedHashMap<String, String> condition, int pageNo, int pageSize, String order);
	
	public List<T> getAllList(LinkedHashMap<String, String> condition);
	
	public List<T> getAllList(LinkedHashMap<String, String> condition, String order);

	T getOne(LinkedHashMap<String, String> condition);

	List<T> getList(LinkedHashMap<String, String> condition, int pageNo, int pageSize, String order, String field);
}

~~~

~~~java
package com.plan.plan.mapper;
import com.plan.common.IOperations;
import com.plan.plan.domain.Cat;
/** 
* 
* @author 吴彬 的  autoWeb 自动代码 网址  www.wubin9.com 
* @data 2019年11月22日 11:48:32  
* 此文件由 www.wubin9.com 网站的自动代码 autoWeb 自动生成。 
* 可以根据需求随意修改，如果需要帮助，请联系 吴彬 
* 联系方式：QQ 810978593  微信  wubin0830bingo 邮箱 wubin5922@dingtalk.com 
*/  

public interface ICatMapper extends IOperations<Cat> {
}


~~~