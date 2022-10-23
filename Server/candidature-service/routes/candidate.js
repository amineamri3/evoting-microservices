const express = require("express");
const multer = require("multer");
const { v4: uuidv4 } = require('uuid');
const mime = require("mime")
const router = express.Router();
const candidateController = require("../controllers/condidateController")
const candidateControllerInst = new candidateController()

const storage = multer.diskStorage({
    destination: function (req, file, cb) {
        cb(null, './uploads')
    },
    filename: function (req, file, cb) {
        file.originalname = uuidv4()+"."+mime.getExtension(file.mimetype)
        cb(null, file.originalname );
    }
});
const upload = multer({storage})

router.post("/uploadCV",upload.single('cv'),(req,res)=>{
    candidateControllerInst.uploadAndResolveCV(req,res)
})
router.get("/download/:name",(req,res)=>{
    candidateControllerInst.downloadFile(req,res)
})
router.put("/update",(req,res)=>{
    candidateControllerInst.updateData(req,res)
})
router.delete("/delete",(req,res)=>{
    candidateControllerInst.deleteData(req,res)
})

module.exports = router;