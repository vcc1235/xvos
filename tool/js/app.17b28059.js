(function(e){function t(t){for(var r,a,l=t[0],c=t[1],s=t[2],u=0,d=[];u<l.length;u++)a=l[u],Object.prototype.hasOwnProperty.call(i,a)&&i[a]&&d.push(i[a][0]),i[a]=0;for(r in c)Object.prototype.hasOwnProperty.call(c,r)&&(e[r]=c[r]);p&&p(t);while(d.length)d.shift()();return o.push.apply(o,s||[]),n()}function n(){for(var e,t=0;t<o.length;t++){for(var n=o[t],r=!0,a=1;a<n.length;a++){var l=n[a];0!==i[l]&&(r=!1)}r&&(o.splice(t--,1),e=c(c.s=n[0]))}return e}var r={},a={app:0},i={app:0},o=[];function l(e){return c.p+"js/"+({}[e]||e)+"."+{"chunk-2d0d7bec":"88ba84ed","chunk-3793de98":"0f09c7c6","chunk-3a6bcbb4":"27c8d683"}[e]+".js"}function c(t){if(r[t])return r[t].exports;var n=r[t]={i:t,l:!1,exports:{}};return e[t].call(n.exports,n,n.exports,c),n.l=!0,n.exports}c.e=function(e){var t=[],n={"chunk-3793de98":1,"chunk-3a6bcbb4":1};a[e]?t.push(a[e]):0!==a[e]&&n[e]&&t.push(a[e]=new Promise((function(t,n){for(var r="css/"+({}[e]||e)+"."+{"chunk-2d0d7bec":"31d6cfe0","chunk-3793de98":"9d595bfc","chunk-3a6bcbb4":"b44f7004"}[e]+".css",i=c.p+r,o=document.getElementsByTagName("link"),l=0;l<o.length;l++){var s=o[l],u=s.getAttribute("data-href")||s.getAttribute("href");if("stylesheet"===s.rel&&(u===r||u===i))return t()}var d=document.getElementsByTagName("style");for(l=0;l<d.length;l++){s=d[l],u=s.getAttribute("data-href");if(u===r||u===i)return t()}var p=document.createElement("link");p.rel="stylesheet",p.type="text/css",p.onload=t,p.onerror=function(t){var r=t&&t.target&&t.target.src||i,o=new Error("Loading CSS chunk "+e+" failed.\n("+r+")");o.code="CSS_CHUNK_LOAD_FAILED",o.request=r,delete a[e],p.parentNode.removeChild(p),n(o)},p.href=i;var f=document.getElementsByTagName("head")[0];f.appendChild(p)})).then((function(){a[e]=0})));var r=i[e];if(0!==r)if(r)t.push(r[2]);else{var o=new Promise((function(t,n){r=i[e]=[t,n]}));t.push(r[2]=o);var s,u=document.createElement("script");u.charset="utf-8",u.timeout=120,c.nc&&u.setAttribute("nonce",c.nc),u.src=l(e);var d=new Error;s=function(t){u.onerror=u.onload=null,clearTimeout(p);var n=i[e];if(0!==n){if(n){var r=t&&("load"===t.type?"missing":t.type),a=t&&t.target&&t.target.src;d.message="Loading chunk "+e+" failed.\n("+r+": "+a+")",d.name="ChunkLoadError",d.type=r,d.request=a,n[1](d)}i[e]=void 0}};var p=setTimeout((function(){s({type:"timeout",target:u})}),12e4);u.onerror=u.onload=s,document.head.appendChild(u)}return Promise.all(t)},c.m=e,c.c=r,c.d=function(e,t,n){c.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:n})},c.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},c.t=function(e,t){if(1&t&&(e=c(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var n=Object.create(null);if(c.r(n),Object.defineProperty(n,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var r in e)c.d(n,r,function(t){return e[t]}.bind(null,r));return n},c.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return c.d(t,"a",t),t},c.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},c.p="",c.oe=function(e){throw console.error(e),e};var s=window["webpackJsonp"]=window["webpackJsonp"]||[],u=s.push.bind(s);s.push=t,s=s.slice();for(var d=0;d<s.length;d++)t(s[d]);var p=u;o.push([0,"chunk-vendors"]),n()})({0:function(e,t,n){e.exports=n("56d7")},"034f":function(e,t,n){"use strict";n("64a9")},"0e2b":function(e,t,n){"use strict";var r=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",[n("div",{staticStyle:{padding:"0 20px"}},[n("el-button",{staticStyle:{"margin-right":"10px"},attrs:{size:"mini"},on:{click:e.scaleAction}},[e._v(e._s(e.show?"收起":"展开"))]),n("el-popover",{attrs:{placement:"bottom",width:"200",trigger:"click"}},[n("div",[e._l(Object.keys(e.value.properties),(function(t,r){return n("div",{key:r,staticStyle:{padding:"4px 0"}},[e._v(e._s(t))])})),n("div",{staticClass:"flex-row"},[n("el-input",{attrs:{size:"mini"},model:{value:e.model,callback:function(t){e.model=t},expression:"model"}}),n("el-button",{attrs:{size:"mini"},on:{click:e.addProperties}},[e._v("添加")])],1)],2),n("el-button",{attrs:{slot:"reference",size:"mini"},slot:"reference"},[e._v("Properties")])],1)],1),e._l(Object.keys(e.value.properties),(function(t,r){return n("div",{directives:[{name:"show",rawName:"v-show",value:e.show,expression:"show"}],key:r},[n("table-column",{on:{delete:e.deleteAction},model:{value:e.value.properties[t],callback:function(n){e.$set(e.value.properties,t,n)},expression:"value.properties[item]"}})],1)}))],2)},a=[],i=(n("ac6a"),n("456d"),n("96cf"),n("1da1")),o=n("ee68"),l={name:"tableObject",props:{value:{}},data:function(){return{model:"",show:!0}},methods:{addProperties:function(){var e=Object(i["a"])(regeneratorRuntime.mark((function e(){var t;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:if(t=Object.keys(this.value.properties),-1===t.indexOf(this.model)){e.next=4;break}return this.$message.error("已存在该属性"),e.abrupt("return");case 4:return e.next=6,this.$nextTick();case 6:this.value.properties[this.model]={type:"string",key:this.model,properties:{},value:Object(o["a"])("string")},this.model="";case 8:case"end":return e.stop()}}),e,this)})));function t(){return e.apply(this,arguments)}return t}(),deleteAction:function(){var e=Object(i["a"])(regeneratorRuntime.mark((function e(t){var n;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return n=t.key,e.next=3,this.$nextTick();case 3:delete this.value.properties[n],this.$forceUpdate();case 5:case"end":return e.stop()}}),e,this)})));function t(t){return e.apply(this,arguments)}return t}(),scaleAction:function(){this.show=!this.show}}},c=l,s=n("2877"),u=Object(s["a"])(c,r,a,!1,null,"18df009b",null);t["a"]=u.exports},"1a5d":function(e,t,n){var r={"./home/home.vue":["77b8","chunk-2d0d7bec"],"./sign/sign.vue":["6be2","chunk-3a6bcbb4"],"./vue/table.vue":["351c","chunk-3793de98"]};function a(e){if(!n.o(r,e))return Promise.resolve().then((function(){var t=new Error("Cannot find module '"+e+"'");throw t.code="MODULE_NOT_FOUND",t}));var t=r[e],a=t[0];return n.e(t[1]).then((function(){return n(a)}))}a.keys=function(){return Object.keys(r)},a.id="1a5d",e.exports=a},"56d7":function(e,t,n){"use strict";n.r(t);n("cadf"),n("551c"),n("f751"),n("097d");var r=n("2b0e"),a=(n("7b75"),function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{attrs:{id:"app"}},[n("router-view")],1)}),i=[],o={name:"app"},l=o,c=(n("034f"),n("2877")),s=Object(c["a"])(l,a,i,!1,null,null,null),u=s.exports,d=(n("7f7f"),n("ac6a"),n("8c4f")),p=n("2f62");r["default"].use(p["a"]);var f=new p["a"].Store({state:{routes:[],menu:[]},actions:{setRoutes:function(e,t){var n=e.state;n.routes=t},setMenu:function(e,t){var n=e.state;n.menu=t}}}),h=f,m=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"flex-row flex-1"},[n("div",{staticClass:"flex-column flex-just-center flex-align-end",staticStyle:{width:"60px","background-color":"#f2f2f2"}},e._l(e.menus,(function(t,r){return n("div",{key:r,staticClass:"flex-row flex-just-center flex-align-center",staticStyle:{width:"100%"}},[n("span",[e._v(e._s(t.label))])])})),0),n("div",{staticClass:"flex-column",staticStyle:{width:"200px"}},[n("el-scrollbar",{staticClass:"flex-1 h-0",staticStyle:{"background-color":"#304156"},attrs:{"wrap-class":"el-scrollbar__wrap"}},[n("el-menu",{attrs:{"active-text-color":e.activeTextColor,"text-color":e.textColor,"background-color":e.backgroundColor,collapse:e.collapse}},e._l(e.pages,(function(t,r){return n("side-bar",e._b({key:r,attrs:{path:"",item:t}},"side-bar",e.$attrs,!1))})),1)],1)],1),n("div",{staticClass:"flex-1 w-0 flex-column"},[n("div"),n("div",{staticClass:"v-padding-20 flex-1 h-0 flex-column",staticStyle:{"background-color":"#f2f2f2"}},[n("router-view")],1)])])},v=[],b=function(){var e=this,t=e.$createElement,n=e._self._c||t;return void 0===e.item.hidden||!1===e.item.hidden?n("div",[e.oneChild?[n("div",{on:{click:function(t){return e.linkTo(e.sideItem.path)}}},[n("el-menu-item",{attrs:{index:e.getSidePath(e.sideItem.path)}},[n("span",{attrs:{slot:"title"},slot:"title"},[e._v(e._s(e.sideItem.label))])])],1)]:n("el-submenu",{ref:"subMenu",class:{"el-collapse-transition-span":e.collapse},staticStyle:{"background-color":"#1a1a1f"},attrs:{index:e.getSidePath(e.sideItem.path),"popper-append-to-body":"",backgroundColor:"#222222"}},[n("template",{slot:"title"},[n("span",{attrs:{slot:"title"},slot:"title"},[e._v(e._s(e.sideItem.label))])]),e._l(e.sideItem.children,(function(t,r){return n("side-bar",{key:r,attrs:{item:t,path:e.getSidePath(e.sideItem.path),nest:!0}})}))],2)],2):e._e()},g=[],y={name:"sideBar",props:{item:{},path:{default:""}},computed:{oneChild:function(){return!(void 0!==this.sideItem&&void 0!==this.sideItem.children&&null!==this.sideItem.children&&this.sideItem.children.length>0)},collapse:function(){return this.$store.state.collapse}},data:function(){return{sideItem:{}}},watch:{item:{handler:function(e){this.sideItem=Object.assign({},e),this.reloadSieItem()},immediate:!0}},methods:{getSidePath:function(e){return this.path.lastIndexOf("/")===this.path.length-1?this.path+e:this.path+"/"+e},linkTo:function(e){var t=this.getSidePath(e);this.$router.push(t)},getRelativePath:function(e,t){return e.lastIndexOf("/")===e.length-1?e+t:e+"/"+t},reloadSieItem:function(){var e=!(void 0!==this.item&&void 0!==this.item.children&&null!==this.item.children&&this.item.children.length>0);if(!1===e&&1===this.item.children.length&&this.item.always){var t=this.item.children[0];this.sideItem.path=this.getRelativePath(this.item.path,t.path),this.sideItem.meta=t.meta,this.sideItem.name=t.name,this.sideItem.label=t.label,this.sideItem.children=[]}}}},x=y,w=Object(c["a"])(x,b,g,!1,null,"63b552cb",null),k=w.exports,_={name:"layout",data:function(){return{activeTextColor:"#409eff",textColor:"#bfcbd9",backgroundColor:"#304156"}},components:{sideBar:k},computed:{pages:function(){return this.$store.state.routes},collapse:function(){return this.$store.state.collapse},menus:function(){return this.$store.state.menu}},mounted:function(){}},j=_,O=Object(c["a"])(j,m,v,!1,null,"36f0c8db",null),S=O.exports,$=[{path:"/",component:"default",redirect:"/home",always:!0,children:[{path:"home",label:"首页",component:"home/home"}]},{path:"/sign",component:"default",label:"加密",redirect:"/sign/xcode",children:[{path:"xcode",label:"自定签名",component:"sign/sign"}]},{path:"/view",component:"default",label:"页面",redirect:"/view/create",children:[{path:"create",label:"Vue Table",component:"vue/table"}]}],C=$;r["default"].use(d["a"]);var P=d["a"].prototype.push;function T(e){return function(){return n("1a5d")("./".concat(e,".vue"))}}function I(e){var t=[];return"string"===typeof e&&(e=JSON.parse(e)),e.forEach((function(e){var n={};if("default"===e.component)n.component=S;else try{n.component=T(e.component)}catch(r){n.component=T("error/error")}void 0!==e.children&&e.children.length>0&&(n.children=I(e.children)),void 0!==e.redirect&&(n.redirect=e.redirect),void 0!==e.always&&(n.always=e.always),void 0!==e.path&&(n.path=e.path),n.meta={title:e.label,icon:e.icon},n.label=e.label,n.name=e.name,t.push(n)})),t}d["a"].prototype.push=function(e){return P.call(this,e).catch((function(e){return e}))};var E=I(C);console.log(E),h.dispatch("setMenu",[{label:"工具",list:C}]).then((function(){})),h.dispatch("setRoutes",E).then((function(){}));var A=new d["a"]({routes:E}),R=n("5c96"),N=n.n(R),z=(n("0fae"),n("8ea8")),L=n.n(z),M=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticStyle:{padding:"0 20px"}},[n("el-input",{attrs:{size:"mini"},on:{input:e.updateChangeAction},model:{value:e.value.value,callback:function(t){e.$set(e.value,"value",t)},expression:"value.value"}})],1)},U=[],D=(n("96cf"),n("1da1")),B={name:"tableString",props:{value:{}},data:function(){return{}},mounted:function(){},methods:{updateChangeAction:function(){var e=Object(D["a"])(regeneratorRuntime.mark((function e(){return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.next=2,this.$nextTick();case 2:this.$forceUpdate();case 3:case"end":return e.stop()}}),e,this)})));function t(){return e.apply(this,arguments)}return t}()}},J=B,V=Object(c["a"])(J,M,U,!1,null,"614e15b8",null),q=V.exports,F=n("0e2b"),H=n("6500"),K=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticStyle:{border:"1px solid #ddd",margin:"8px","border-radius":"5px",padding:"10px 0"}},[n("el-row",[n("el-col",{attrs:{span:5}},[n("span",{staticStyle:{padding:"0 20px","font-size":"18px"}},[e._v(e._s(e.value.key||""))])]),n("el-col",{attrs:{span:5}},[n("el-select",{attrs:{disabled:e.disable,size:"mini"},on:{change:e.changeValue},model:{value:e.value.type,callback:function(t){e.$set(e.value,"type",t)},expression:"value.type"}},e._l(e.jsonType,(function(e,t){return n("el-option",{key:t,attrs:{label:e,value:e}})})),1)],1),e.deleteShow?n("el-col",{attrs:{span:5}},[n("el-button",{attrs:{size:"mini",type:"danger"},on:{click:e.deleteProperties}},[e._v("删除")])],1):e._e()],1),n("div",{staticStyle:{padding:"10px 0"}},["array"===e.value.type?n("table-array",{model:{value:e.value,callback:function(t){e.value=t},expression:"value"}}):e._e(),"object"===e.value.type?n("table-object",{model:{value:e.value,callback:function(t){e.value=t},expression:"value"}}):e._e(),"string"===e.value.type?n("table-string",{model:{value:e.value,callback:function(t){e.value=t},expression:"value"}}):e._e()],1)],1)},G=[],Q=n("ee68"),W={name:"tableColumn",props:{value:{},deleteShow:{default:!0},disable:{default:!1}},data:function(){return{}},watch:{},computed:{jsonType:function(){return Q["b"]}},methods:{changeValue:function(e){this.value.value=Object(Q["a"])(e),this.$forceUpdate()},deleteProperties:function(){this.$emit("delete",this.value)}}},X=W,Y=Object(c["a"])(X,K,G,!1,null,"58942196",null),Z=Y.exports;r["default"].component("table-string",q),r["default"].component("table-object",F["a"]),r["default"].component("table-array",H["a"]),r["default"].component("table-column",Z);n("c46a");var ee=n("f359");r["default"].config.productionTip=!1,r["default"].use(N.a),r["default"].use(L.a);var te={table:[{label:"用户名",prop:"username"},{label:"昵称",prop:"nickname"},{label:"时间",prop:"time",formatter:"formatterDate"}],isNew:{label:"新增记录",action:"addRecord"},options:[{label:"查看",action:"toViewData"},{label:"删除",action:"deleteAction"}],header:[{label:"用户名",prop:"username"},{label:"时间",prop:"time"}],config:{config:{},dataList:[],current:0,limit:10}},ne=Object(ee["a"])(te);console.log(ne),new r["default"]({router:A,store:h,render:function(e){return e(u)}}).$mount("#app")},"64a9":function(e,t,n){},6500:function(e,t,n){"use strict";var r=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticStyle:{padding:"0 20px"}},[n("div",[n("el-button",{staticStyle:{"margin-right":"10px"},attrs:{size:"mini"},on:{click:e.scaleAction}},[e._v(e._s(e.show?"收起":"展开"))]),n("el-button",{attrs:{size:"mini"},on:{click:e.addProperties}},[e._v("添加")])],1),e._l(Object.keys(e.value.properties),(function(t,r){return n("div",{directives:[{name:"show",rawName:"v-show",value:e.show,expression:"show"}],key:r},[n("table-column",{on:{delete:e.deleteAction},model:{value:e.value.properties[t],callback:function(n){e.$set(e.value.properties,t,n)},expression:"value.properties[item]"}})],1)}))],2)},a=[],i=(n("96cf"),n("1da1")),o={name:"tableArray",props:{value:{}},data:function(){return{show:!0,indexT:0}},methods:{addProperties:function(){var e=Object(i["a"])(regeneratorRuntime.mark((function e(){var t;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return void 0===this.value.properties&&(this.value.properties={}),++this.indexT,t=this.indexT,console.log(t),e.next=6,this.$nextTick();case 6:this.value.properties["item".concat(t)]={type:"string",value:"",properties:{},key:"item".concat(t)},this.$forceUpdate();case 8:case"end":return e.stop()}}),e,this)})));function t(){return e.apply(this,arguments)}return t}(),scaleAction:function(){this.show=!this.show},deleteAction:function(){var e=Object(i["a"])(regeneratorRuntime.mark((function e(t){var n;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return n=t.key,e.next=3,this.$nextTick();case 3:delete this.value.properties[n],this.$forceUpdate();case 5:case"end":return e.stop()}}),e,this)})));function t(t){return e.apply(this,arguments)}return t}()}},l=o,c=n("2877"),s=Object(c["a"])(l,r,a,!1,null,"cb4d3d5c",null);t["a"]=s.exports},"7b75":function(e,t,n){},ee68:function(e,t,n){"use strict";n.d(t,"b",(function(){return r})),n.d(t,"a",(function(){return a}));var r=["string","array","object","boolean","null"],a=function(e){switch(e){case"string":return"";case"array":return[];case"object":return{};case"boolean":return!1;case"null":return null}}},f359:function(e,t,n){"use strict";n.d(t,"a",(function(){return c}));n("ac6a"),n("456d");function r(e){var t=arguments.length>1&&void 0!==arguments[1]?arguments[1]:"js",n="\n";"js"!==t&&(n+="<script>"),n+="export default {\n",n+=' name: "'.concat(e.label||"table-column",'",\n'),n+=" data () { \n\t return {\n";for(var r=Object.keys(e.config||{}),a=0;a<r.length;a++){var i=r[a];n+="\t\t".concat(i,": ").concat(JSON.stringify(e.config[i]),",\n")}n+="\t\t}\n\t},\n",n+=" mounted(){\n        \n    },\n",n+=" methods: {\n";var o=e.options,l=e.isNew;return null!==o&&void 0!==o&&o.forEach((function(e){n+="\t".concat(e.action,"() {\n\t},\n")})),null!==l&&void 0!==l&&(n+="\t".concat(l.action,"() {\n\t},\n")),n+="  },\n","js"===t&&(n+="  template"),n+="\n}","js"!==t&&(n+="<\/script>"),n}function a(){}function i(e){var t='const template = `<div class="flex-1 h-0 flex-column " style="background-color: #ffffff">\n<v-content-table class="flex-1 h-0" :is-page="true" :data="dataList" v-model="current">\n';return t+=o(e),t+=l(e),t+="</v-content-table>\n    </div>`",t}function o(e){var t=e.table,n=e.isNew,r=e.options;if(void 0===t||0===t.length)return"";for(var a="",i=0;i<t.length;i++){var o=t[i];a+="\t<el-table-column ",a+=o.label?'label="'.concat(o.label,'" '):" ",a+=o.prop?'prop="'.concat(o.prop,'" '):" ",a+=o.formatter?':formatter="'.concat(o.formatter,'" '):" ",a+=">\n\t</el-table-column>\t\n"}if(void 0!==r){void 0!==n?(a+="\t<el-table-column>\n",a+='\t\t<template slot="header">\n',a+='\t\t\t<el-button type="primary" size="mini" @click="'.concat(n.action,'">').concat(n.label,"</el-button>\n"),a+="\t\t</template>\n"):a+='<el-table-column label="操作">';for(var l=0;l<r.length;l++){var c=r[l];a+='\t\t<el-button type="'.concat(c.type||"default",'" size="mini" @click="').concat(c.action,'">').concat(c.label,"</el-button>\n")}a+="\t</el-table-column>\n"}return a}function l(e){var t=e.header;if(void 0===t||0===t.length)return"";for(var n='<template slot="header">\n    <el-form label-width="100px">\n    <el-row>',r=0;r<t.length;r++){var a=t[r];n+='\n\t<el-col :span="6">',n+='\n\t<el-form-item label="'.concat(a.label,'">'),n+='\n\t<el-input v-model="config.'.concat(a.prop,'"></el-input>'),n+="\n\t</el-form-item>",n+="\n\t</el-col>"}return n+="\n\t</el-row>\n\t</el-form>\n</template>\n",n}var c=function(e){var t=arguments.length>1&&void 0!==arguments[1]?arguments[1]:"js",n="";return n+="js"===t?i(e):a(e),n+=r(e),n}}});
//# sourceMappingURL=app.17b28059.js.map