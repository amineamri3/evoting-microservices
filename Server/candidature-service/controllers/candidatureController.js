const axios = require("axios")
const defaultData = require("../defaultdata")
const candidatureModel = require("../models/candidature")
const { uniqueNamesGenerator, Config, starWars } = require ('unique-names-generator');
const { token } = require("morgan");

class condidateController {

    async uploadAndResolveCV(req,res) {
        let api_result = null
        let candidate_data;
        /*api_result = await axios.get(`https://api}`,{
            headers:{
                "apikey":"gNoCFMNQBfLqUGoDtODxxbBX3qj2sMwM"
            },
        })*/
        if (api_result)
            candidate_data = api_result.data
        else{
            candidate_data = defaultData
            candidate_data.name =""
        }

        const created_data = await candidatureModel.create({raw_data:candidate_data})
        
        try{
        await axios.post("http://192.168.1.9:8083/candidates/",candidate_data)
        }catch(err){
            console.log(err)
        }
        candidate_data._id = created_data._id       
        return res.json({status:"done",candidate_data})
    }

    async inscrire(req,res) {
        //get token and election from payload
        jwt = req.body.token
        electionid = req.body.election
        if(!jwt || !election) res.json({error:"Bad request"})

        //get cin from auth service
        rescin = await axios.get("http://localhost:7999/auth-service/ValidateJwt",{}, {
            headers: {
              'Authorization': `Bearer ${jwt}` 
            }
          })

        if (! rescin) return res.json({status:"Auth failed"})

        str = JSON.stringify(rescin);
        console.log(str); 
        
        
        //get user data from user service
        user = await axios.get("http://localhost:7999/user-service/user/getByCin/"+cin)

        if (! user) return res.json({status:"User service failed"})
        //sign the user up for the election

        candidatureModel.create({cin: rescin, election: electionid, status:"pending"})

    }



    async desinscrire(req,res) {
        //get token and election from payload
        jwt = req.body.token
        electionid = req.body.election
        if(!jwt || !election) res.json({error:"Bad request"})

        //get cin from auth service
        rescin = await axios.get("http://localhost:7999/auth-service/ValidateJwt",{}, {
            headers: {
              'Authorization': `Bearer ${jwt}` 
            }
          })

        if (! rescin) return res.json({status:"Auth failed"})
        
        str = JSON.stringify(rescin);
        console.log(str); 
        
        
        //get user data from user service
        user = await axios.get("http://localhost:7999/user-service/user/getByCin/"+cin)

        if (! user) return res.json({status:"User service failed"})
        //sign the user up for the election

        candidatureModel.find({ cin: rescin, election: electionid }).remove().exec();

    }


    async accept(req,res) {
        //get token and election from payload
        jwt = req.body.token
        electionid = req.body.election
        candidateid = req.body.candidate
        if(!jwt || !election || !candidateid) res.json({error:"Bad request"})

        //get cin from auth service
        rescin = await axios.get("http://localhost:7999/auth-service/ValidateJwt",{}, {
            headers: {
              'Authorization': `Bearer ${jwt}` 
            }
          })

        if (! rescin) return res.json({status:"Auth failed"})
        
        str = JSON.stringify(rescin);
        console.log(str); 
        
        
        //get user data from user service
        // and check role
        user = await axios.get("http://localhost:7999/user-service/user/getByCin/"+cin)

        if (! user) return res.json({status:"User service failed"})

        if (user.role != "AUTHORITY") return res.json({status:"No permission"})
        //sign the user up for the election

        candidatureModel.find({ cin: rescin, election: electionid }).remove().exec();

        await candidatureModel.findByIdAndUpdate({ElectionId: electionid, CandidateId: candidateid }, {
            Status: "Accepted"
        })

    }

    async refuse(req,res) {
        //get token and election from payload
        jwt = req.body.token
        electionid = req.body.election
        candidateid = req.body.candidate
        if(!jwt || !election || !candidateid) res.json({error:"Bad request"})

        //get cin from auth service
        rescin = await axios.get("http://localhost:7999/auth-service/ValidateJwt",{}, {
            headers: {
              'Authorization': `Bearer ${jwt}` 
            }
          })

        if (! rescin) return res.json({status:"Auth failed"})
        
        str = JSON.stringify(rescin);
        console.log(str); 
        
        
        //get user data from user service
        // and check role
        user = await axios.get("http://localhost:7999/user-service/user/getByCin/"+cin)

        if (! user) return res.json({status:"User service failed"})

        if (user.role != "AUTHORITY") return res.json({status:"No permission"})
        //sign the user up for the election


        await candidatureModel.findByIdAndUpdate({ElectionId: electionid, CandidateId: candidateid }, {
            Status: "Refused"
        })

    }


}

module.exports = condidateController