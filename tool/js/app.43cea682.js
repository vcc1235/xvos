(function(e){function t(t){for(var r,a,s=t[0],l=t[1],c=t[2],u=0,d=[];u<s.length;u++)a=s[u],Object.prototype.hasOwnProperty.call(i,a)&&i[a]&&d.push(i[a][0]),i[a]=0;for(r in l)Object.prototype.hasOwnProperty.call(l,r)&&(e[r]=l[r]);p&&p(t);while(d.length)d.shift()();return o.push.apply(o,c||[]),n()}function n(){for(var e,t=0;t<o.length;t++){for(var n=o[t],r=!0,a=1;a<n.length;a++){var s=n[a];0!==i[s]&&(r=!1)}r&&(o.splice(t--,1),e=l(l.s=n[0]))}return e}var r={},a={app:0},i={app:0},o=[];function s(e){return l.p+"js/"+({}[e]||e)+"."+{"chunk-2d0d7bec":"88ba84ed","chunk-3a6bcbb4":"27c8d683","chunk-44faa298":"3ae9266d"}[e]+".js"}function l(t){if(r[t])return r[t].exports;var n=r[t]={i:t,l:!1,exports:{}};return e[t].call(n.exports,n,n.exports,l),n.l=!0,n.exports}l.e=function(e){var t=[],n={"chunk-3a6bcbb4":1,"chunk-44faa298":1};a[e]?t.push(a[e]):0!==a[e]&&n[e]&&t.push(a[e]=new Promise((function(t,n){for(var r="css/"+({}[e]||e)+"."+{"chunk-2d0d7bec":"31d6cfe0","chunk-3a6bcbb4":"b44f7004","chunk-44faa298":"e37c90e0"}[e]+".css",i=l.p+r,o=document.getElementsByTagName("link"),s=0;s<o.length;s++){var c=o[s],u=c.getAttribute("data-href")||c.getAttribute("href");if("stylesheet"===c.rel&&(u===r||u===i))return t()}var d=document.getElementsByTagName("style");for(s=0;s<d.length;s++){c=d[s],u=c.getAttribute("data-href");if(u===r||u===i)return t()}var p=document.createElement("link");p.rel="stylesheet",p.type="text/css",p.onload=t,p.onerror=function(t){var r=t&&t.target&&t.target.src||i,o=new Error("Loading CSS chunk "+e+" failed.\n("+r+")");o.code="CSS_CHUNK_LOAD_FAILED",o.request=r,delete a[e],p.parentNode.removeChild(p),n(o)},p.href=i;var h=document.getElementsByTagName("head")[0];h.appendChild(p)})).then((function(){a[e]=0})));var r=i[e];if(0!==r)if(r)t.push(r[2]);else{var o=new Promise((function(t,n){r=i[e]=[t,n]}));t.push(r[2]=o);var c,u=document.createElement("script");u.charset="utf-8",u.timeout=120,l.nc&&u.setAttribute("nonce",l.nc),u.src=s(e);var d=new Error;c=function(t){u.onerror=u.onload=null,clearTimeout(p);var n=i[e];if(0!==n){if(n){var r=t&&("load"===t.type?"missing":t.type),a=t&&t.target&&t.target.src;d.message="Loading chunk "+e+" failed.\n("+r+": "+a+")",d.name="ChunkLoadError",d.type=r,d.request=a,n[1](d)}i[e]=void 0}};var p=setTimeout((function(){c({type:"timeout",target:u})}),12e4);u.onerror=u.onload=c,document.head.appendChild(u)}return Promise.all(t)},l.m=e,l.c=r,l.d=function(e,t,n){l.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:n})},l.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},l.t=function(e,t){if(1&t&&(e=l(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var n=Object.create(null);if(l.r(n),Object.defineProperty(n,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var r in e)l.d(n,r,function(t){return e[t]}.bind(null,r));return n},l.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return l.d(t,"a",t),t},l.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},l.p="",l.oe=function(e){throw console.error(e),e};var c=window["webpackJsonp"]=window["webpackJsonp"]||[],u=c.push.bind(c);c.push=t,c=c.slice();for(var d=0;d<c.length;d++)t(c[d]);var p=u;o.push([0,"chunk-vendors"]),n()})({0:function(e,t,n){e.exports=n("56d7")},"034f":function(e,t,n){"use strict";n("64a9")},"0e2b":function(e,t,n){"use strict";var r=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",[n("div",{staticStyle:{padding:"0 20px"}},[n("el-button",{staticStyle:{"margin-right":"10px"},attrs:{size:"mini"},on:{click:e.scaleAction}},[e._v(e._s(e.show?"收起":"展开"))]),n("el-popover",{attrs:{placement:"bottom",width:"200",trigger:"click"}},[n("div",[e._l(Object.keys(e.value.properties),(function(t,r){return n("div",{key:r,staticStyle:{padding:"4px 0"}},[e._v(e._s(t))])})),n("div",{staticClass:"flex-row"},[n("el-input",{attrs:{size:"mini"},model:{value:e.model,callback:function(t){e.model=t},expression:"model"}}),n("el-button",{attrs:{size:"mini"},on:{click:e.addProperties}},[e._v("添加")])],1)],2),n("el-button",{attrs:{slot:"reference",size:"mini"},slot:"reference"},[e._v("Properties")])],1)],1),e._l(Object.keys(e.value.properties),(function(t,r){return n("div",{directives:[{name:"show",rawName:"v-show",value:e.show,expression:"show"}],key:r},[n("table-column",{on:{delete:e.deleteAction},model:{value:e.value.properties[t],callback:function(n){e.$set(e.value.properties,t,n)},expression:"value.properties[item]"}})],1)}))],2)},a=[],i=(n("ac6a"),n("456d"),n("96cf"),n("1da1")),o=n("ee68"),s={name:"tableObject",props:{value:{}},data:function(){return{model:"",show:!0}},methods:{addProperties:function(){var e=Object(i["a"])(regeneratorRuntime.mark((function e(){var t;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:if(t=Object.keys(this.value.properties),-1===t.indexOf(this.model)){e.next=4;break}return this.$message.error("已存在该属性"),e.abrupt("return");case 4:return e.next=6,this.$nextTick();case 6:this.value.properties[this.model]={type:"string",key:this.model,properties:{},value:Object(o["a"])("string")},this.model="";case 8:case"end":return e.stop()}}),e,this)})));function t(){return e.apply(this,arguments)}return t}(),deleteAction:function(){var e=Object(i["a"])(regeneratorRuntime.mark((function e(t){var n;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return n=t.key,e.next=3,this.$nextTick();case 3:delete this.value.properties[n],this.$forceUpdate();case 5:case"end":return e.stop()}}),e,this)})));function t(t){return e.apply(this,arguments)}return t}(),scaleAction:function(){this.show=!this.show}}},l=s,c=n("2877"),u=Object(c["a"])(l,r,a,!1,null,"18df009b",null);t["a"]=u.exports},"1a5d":function(e,t,n){var r={"./home/home.vue":["77b8","chunk-2d0d7bec"],"./sign/sign.vue":["6be2","chunk-3a6bcbb4"],"./vue/table.vue":["351c","chunk-44faa298"]};function a(e){if(!n.o(r,e))return Promise.resolve().then((function(){var t=new Error("Cannot find module '"+e+"'");throw t.code="MODULE_NOT_FOUND",t}));var t=r[e],a=t[0];return n.e(t[1]).then((function(){return n(a)}))}a.keys=function(){return Object.keys(r)},a.id="1a5d",e.exports=a},"56d7":function(e,t,n){"use strict";n.r(t);n("cadf"),n("551c"),n("f751"),n("097d");var r=n("2b0e"),a=(n("7b75"),function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{attrs:{id:"app"}},[n("router-view")],1)}),i=[],o={name:"app"},s=o,l=(n("034f"),n("2877")),c=Object(l["a"])(s,a,i,!1,null,null,null),u=c.exports,d=(n("7f7f"),n("ac6a"),n("8c4f")),p=n("2f62");r["default"].use(p["a"]);var h=new p["a"].Store({state:{routes:[],menu:[]},actions:{setRoutes:function(e,t){var n=e.state;n.routes=t},setMenu:function(e,t){var n=e.state;n.menu=t}}}),f=h,m=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"flex-row flex-1"},[n("div",{staticClass:"flex-column flex-just-center flex-align-end",staticStyle:{width:"60px","background-color":"#f2f2f2"}},e._l(e.menus,(function(t,r){return n("div",{key:r,staticClass:"flex-row flex-just-center flex-align-center",staticStyle:{width:"100%"}},[n("span",[e._v(e._s(t.label))])])})),0),n("div",{staticClass:"flex-column",staticStyle:{width:"200px"}},[n("el-scrollbar",{staticClass:"flex-1 h-0",staticStyle:{"background-color":"#304156"},attrs:{"wrap-class":"el-scrollbar__wrap"}},[n("el-menu",{attrs:{"active-text-color":e.activeTextColor,"text-color":e.textColor,"background-color":e.backgroundColor,collapse:e.collapse}},e._l(e.pages,(function(t,r){return n("side-bar",e._b({key:r,attrs:{path:"",item:t}},"side-bar",e.$attrs,!1))})),1)],1)],1),n("div",{staticClass:"flex-1 w-0 flex-column"},[n("div"),n("div",{staticClass:"v-padding-20 flex-1 h-0 flex-column",staticStyle:{"background-color":"#f2f2f2"}},[n("router-view")],1)])])},v=[],b=function(){var e=this,t=e.$createElement,n=e._self._c||t;return void 0===e.item.hidden||!1===e.item.hidden?n("div",[e.oneChild?[n("div",{on:{click:function(t){return e.linkTo(e.sideItem.path)}}},[n("el-menu-item",{attrs:{index:e.getSidePath(e.sideItem.path)}},[n("span",{attrs:{slot:"title"},slot:"title"},[e._v(e._s(e.sideItem.label))])])],1)]:n("el-submenu",{ref:"subMenu",class:{"el-collapse-transition-span":e.collapse},staticStyle:{"background-color":"#1a1a1f"},attrs:{index:e.getSidePath(e.sideItem.path),"popper-append-to-body":"",backgroundColor:"#222222"}},[n("template",{slot:"title"},[n("span",{attrs:{slot:"title"},slot:"title"},[e._v(e._s(e.sideItem.label))])]),e._l(e.sideItem.children,(function(t,r){return n("side-bar",{key:r,attrs:{item:t,path:e.getSidePath(e.sideItem.path),nest:!0}})}))],2)],2):e._e()},g=[],y={name:"sideBar",props:{item:{},path:{default:""}},computed:{oneChild:function(){return!(void 0!==this.sideItem&&void 0!==this.sideItem.children&&null!==this.sideItem.children&&this.sideItem.children.length>0)},collapse:function(){return this.$store.state.collapse}},data:function(){return{sideItem:{}}},watch:{item:{handler:function(e){this.sideItem=Object.assign({},e),this.reloadSieItem()},immediate:!0}},methods:{getSidePath:function(e){return this.path.lastIndexOf("/")===this.path.length-1?this.path+e:this.path+"/"+e},linkTo:function(e){var t=this.getSidePath(e);this.$router.push(t)},getRelativePath:function(e,t){return e.lastIndexOf("/")===e.length-1?e+t:e+"/"+t},reloadSieItem:function(){var e=!(void 0!==this.item&&void 0!==this.item.children&&null!==this.item.children&&this.item.children.length>0);if(!1===e&&1===this.item.children.length&&this.item.always){var t=this.item.children[0];this.sideItem.path=this.getRelativePath(this.item.path,t.path),this.sideItem.meta=t.meta,this.sideItem.name=t.name,this.sideItem.label=t.label,this.sideItem.children=[]}}}},x=y,w=Object(l["a"])(x,b,g,!1,null,"63b552cb",null),k=w.exports,_={name:"layout",data:function(){return{activeTextColor:"#409eff",textColor:"#bfcbd9",backgroundColor:"#304156"}},components:{sideBar:k},computed:{pages:function(){return this.$store.state.routes},collapse:function(){return this.$store.state.collapse},menus:function(){return this.$store.state.menu}},mounted:function(){}},j=_,O=Object(l["a"])(j,m,v,!1,null,"36f0c8db",null),S=O.exports,$=[{path:"/",component:"default",redirect:"/home",always:!0,children:[{path:"home",label:"首页",component:"home/home"}]},{path:"/sign",component:"default",label:"加密",redirect:"/sign/xcode",children:[{path:"xcode",label:"自定签名",component:"sign/sign"}]},{path:"/view",component:"default",label:"页面",redirect:"/view/create",children:[{path:"create",label:"Vue Table",component:"vue/table"}]}],C=$;r["default"].use(d["a"]);var P=d["a"].prototype.push;function T(e){return function(){return n("1a5d")("./".concat(e,".vue"))}}function I(e){var t=[];return"string"===typeof e&&(e=JSON.parse(e)),e.forEach((function(e){var n={};if("default"===e.component)n.component=S;else try{n.component=T(e.component)}catch(r){n.component=T("error/error")}void 0!==e.children&&e.children.length>0&&(n.children=I(e.children)),void 0!==e.redirect&&(n.redirect=e.redirect),void 0!==e.always&&(n.always=e.always),void 0!==e.path&&(n.path=e.path),n.meta={title:e.label,icon:e.icon},n.label=e.label,n.name=e.name,t.push(n)})),t}d["a"].prototype.push=function(e){return P.call(this,e).catch((function(e){return e}))};var E=I(C);console.log(E),f.dispatch("setMenu",[{label:"工具",list:C}]).then((function(){})),f.dispatch("setRoutes",E).then((function(){}));var A=new d["a"]({routes:E}),R=n("5c96"),z=n.n(R),N=(n("0fae"),n("8ea8")),M=n.n(N),U=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticStyle:{padding:"0 20px"}},[n("el-input",{attrs:{size:"mini"},on:{input:e.updateChangeAction},model:{value:e.value.value,callback:function(t){e.$set(e.value,"value",t)},expression:"value.value"}})],1)},L=[],B=(n("96cf"),n("1da1")),D={name:"tableString",props:{value:{}},data:function(){return{}},mounted:function(){},methods:{updateChangeAction:function(){var e=Object(B["a"])(regeneratorRuntime.mark((function e(){return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.next=2,this.$nextTick();case 2:this.$forceUpdate();case 3:case"end":return e.stop()}}),e,this)})));function t(){return e.apply(this,arguments)}return t}()}},J=D,V=Object(l["a"])(J,U,L,!1,null,"614e15b8",null),q=V.exports,F=n("0e2b"),H=n("6500"),K=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticStyle:{border:"1px solid #ddd",margin:"8px","border-radius":"5px",padding:"10px 0"}},[n("el-row",[n("el-col",{attrs:{span:5}},[n("span",{staticStyle:{padding:"0 20px","font-size":"18px"}},[e._v(e._s(e.value.key||""))])]),n("el-col",{attrs:{span:5}},[n("el-select",{attrs:{disabled:e.disable,size:"mini"},on:{change:e.changeValue},model:{value:e.value.type,callback:function(t){e.$set(e.value,"type",t)},expression:"value.type"}},e._l(e.jsonType,(function(e,t){return n("el-option",{key:t,attrs:{label:e,value:e}})})),1)],1),e.deleteShow?n("el-col",{attrs:{span:5}},[n("el-button",{attrs:{size:"mini",type:"danger"},on:{click:e.deleteProperties}},[e._v("删除")])],1):e._e()],1),n("div",{staticStyle:{padding:"10px 0"}},["array"===e.value.type?n("table-array",{model:{value:e.value,callback:function(t){e.value=t},expression:"value"}}):e._e(),"object"===e.value.type?n("table-object",{model:{value:e.value,callback:function(t){e.value=t},expression:"value"}}):e._e(),"string"===e.value.type?n("table-string",{model:{value:e.value,callback:function(t){e.value=t},expression:"value"}}):e._e()],1)],1)},G=[],Q=n("ee68"),W={name:"tableColumn",props:{value:{},deleteShow:{default:!0},disable:{default:!1}},data:function(){return{}},watch:{},computed:{jsonType:function(){return Q["b"]}},methods:{changeValue:function(e){this.value.value=Object(Q["a"])(e),this.$forceUpdate()},deleteProperties:function(){this.$emit("delete",this.value)}}},X=W,Y=Object(l["a"])(X,K,G,!1,null,"58942196",null),Z=Y.exports;r["default"].component("table-string",q),r["default"].component("table-object",F["a"]),r["default"].component("table-array",H["a"]),r["default"].component("table-column",Z);n("c46a");r["default"].config.productionTip=!1,r["default"].use(z.a),r["default"].use(M.a),new r["default"]({router:A,store:f,render:function(e){return e(u)}}).$mount("#app")},"64a9":function(e,t,n){},6500:function(e,t,n){"use strict";var r=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticStyle:{padding:"0 20px"}},[n("div",[n("el-button",{staticStyle:{"margin-right":"10px"},attrs:{size:"mini"},on:{click:e.scaleAction}},[e._v(e._s(e.show?"收起":"展开"))]),n("el-button",{attrs:{size:"mini"},on:{click:e.addProperties}},[e._v("添加")])],1),e._l(Object.keys(e.value.properties),(function(t,r){return n("div",{directives:[{name:"show",rawName:"v-show",value:e.show,expression:"show"}],key:r},[n("table-column",{on:{delete:e.deleteAction},model:{value:e.value.properties[t],callback:function(n){e.$set(e.value.properties,t,n)},expression:"value.properties[item]"}})],1)}))],2)},a=[],i=(n("96cf"),n("1da1")),o={name:"tableArray",props:{value:{}},data:function(){return{show:!0,indexT:0}},methods:{addProperties:function(){var e=Object(i["a"])(regeneratorRuntime.mark((function e(){var t;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return void 0===this.value.properties&&(this.value.properties={}),++this.indexT,t=this.indexT,console.log(t),e.next=6,this.$nextTick();case 6:this.value.properties["item".concat(t)]={type:"string",value:"",properties:{},key:"item".concat(t)},this.$forceUpdate();case 8:case"end":return e.stop()}}),e,this)})));function t(){return e.apply(this,arguments)}return t}(),scaleAction:function(){this.show=!this.show},deleteAction:function(){var e=Object(i["a"])(regeneratorRuntime.mark((function e(t){var n;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return n=t.key,e.next=3,this.$nextTick();case 3:delete this.value.properties[n],this.$forceUpdate();case 5:case"end":return e.stop()}}),e,this)})));function t(t){return e.apply(this,arguments)}return t}()}},s=o,l=n("2877"),c=Object(l["a"])(s,r,a,!1,null,"cb4d3d5c",null);t["a"]=c.exports},"7b75":function(e,t,n){},ee68:function(e,t,n){"use strict";n.d(t,"b",(function(){return r})),n.d(t,"a",(function(){return a}));var r=["string","array","object","boolean","null"],a=function(e){switch(e){case"string":return"";case"array":return[];case"object":return{};case"boolean":return!1;case"null":return null}}}});
//# sourceMappingURL=app.43cea682.js.map