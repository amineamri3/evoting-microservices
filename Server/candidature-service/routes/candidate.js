const express = require("express");
const { v4: uuidv4 } = require('uuid');
const mime = require("mime")
const router = express.Router();
const candidateController = require("../controllers/candidatureController")
const candidateControllerInst = new candidateController()


router.post("/candidate/inscrire",(req,res)=>{
    candidateControllerInst.inscrire(req,res)
})
router.get("/candidate/desinscrire",(req,res)=>{
    candidateControllerInst.desinscrire(req,res)
})
router.put("/candidate/accept",(req,res)=>{
    candidateControllerInst.accept(req,res)
})
router.delete("candidate/refuse",(req,res)=>{
    candidateControllerInst.refuse(req,res)
})

module.exports = router;