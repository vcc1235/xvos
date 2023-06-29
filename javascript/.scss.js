const fs = require("fs");
const path = require("path");

// 路径
const rootPath = path.resolve(__dirname, "src");
// 输入文件
const outPath = path.join(__dirname, "out.css");
console.log("rootPath==>", rootPath);
// 前缀
const prex = "g-";
// 单位
const pixe = "px";

const classList = {};
function findFile(file) {
  const stat = fs.statSync(file);
  if (stat.isDirectory()) {
    scanDirectory(file);
    return;
  }
  const name = path.extname(file);
  if (name !== ".vue") {
    return;
  }
  searchScssClass(file);
}

function scanDirectory(dir) {
  fs.readdirSync(dir).forEach((name) => {
    findFile(dir + "/" + name);
  });
}

function searchScssClass(file) {
  const content = fs.readFileSync(file, "utf8");
  const matches = content.matchAll(/class=\"([\[a-z0-9A-Z\]| |-]*)\"/g);
  [...matches].forEach((element) => {
    const list = element[1].split(" ");
    list.forEach((item) => {
      if (item.indexOf(prex) === 0) {
        classList[item] = item;
      }
    });
  });
}
const json = {};
findFile(rootPath);
parseClass();

function parseClass() {
  console.log(Object.keys(classList));
  Object.keys(classList).forEach((key) => {
    const list = key.split("-");
    const k = list[1];
    const v = list[2];
    let value = "";
    if (k === "fs") {
      if (list.length === 3) {
        value = `font-size: ${v}${pixe};`;
      }
    }
    if (k === "m") {
      if (list.length === 3) {
        value = `margin: ${v}px;`;
      }
      if (list.length === 4) {
        const t = list[3];
        if (v === "b") {
          value = `margin-bottom: ${t}${pixe};`;
        }
        if (v === "t") {
          value = `margin-top: ${t}${pixe};`;
        }
        if (v === "l") {
          value = `margin-left: ${t}${pixe};`;
        }
        if (v === "r") {
          value = `margin-right: ${t}${pixe};`;
        }
        if (v === "h") {
          value = `margin-left: ${t}${pixe}; margin-right:${t}${pixe};`;
        }
        if (v === "v") {
          value = `margin-top: ${t}${pixe};margin-bottom: ${t}${pixe};`;
        }
      }
    }
    if (k === "p") {
      if (list.length === 3) {
        value = `padding: ${v}${pixe};`;
      }
      if (list.length === 4) {
        const t = list[3];
        if (v === "b") {
          value = `padding-bottom: ${t}${pixe};`;
        }
        if (v === "t") {
          value = `padding-top: ${t}${pixe};`;
        }
        if (v === "l") {
          value = `padding-left: ${t}${pixe};`;
        }
        if (v === "r") {
          value = `padding-right: ${t}${pixe};`;
        }
        if (v === "h") {
          value = `padding-left: ${t}${pixe}; padding-right:${t}${pixe};`;
        }
        if (v === "v") {
          value = `padding-top: ${t}${pixe};padding-bottom: ${t}${pixe};`;
        }
      }
    }
    if (k === "w") {
      value = `width: ${v}${pixe};`;
    }
    if (k === "h") {
      value = `height: ${v}${pixe};`;
    }
    if (value === "") {
      return;
    }
    json[key] = value;
  });
}

function createOutPath(){
    fs.writeFileSync(outPath, "");
    Object.keys(json).forEach(function(key){
        fs.appendFileSync(outPath, `.${key}{ ${json[key]} } `);
    })
}
createOutPath();
