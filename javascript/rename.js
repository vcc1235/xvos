const fs = require("fs");
const path = require("path");
let rootPath = process.argv[2];
let renameType = process.argv[3] || "aaa";

const exist = fs.existsSync(rootPath);
if (!exist) {
  console.error("path is not found");
  return;
}

fs.readdirSync(rootPath).forEach(function (name, idx) {
  let filePath = path.resolve(rootPath, name);
  const extname = path.extname(filePath);
  const rename = path.resolve(rootPath, `${renameType}_${idx}${extname}`);
  console.log(rename);
  fs.renameSync(filePath, rename);
});
