const axios = require("axios")
const defaultData = require("../defaultdata")
const cv = require("../models/candidature")
const { uniqueNamesGenerator, Config, starWars } = require ('unique-names-generator');
const { token } = require("morgan");

class condidateController {

    async uploadAndResolveCV(req,res) {
        console.log(req.file.filename)
        let api_result = null
        let candidate_data;
        /*api_result = await axios.get(`https://api.apilayer.com/resume_parser/url?url=http://fff0-41-225-140-80.ngrok.io/api/candidate/download/${req.file.filename}`,{
            headers:{
                "apikey":"gNoCFMNQBfLqUGoDtODxxbBX3qj2sMwM"
            },
        })*/
        if (api_result)
            candidate_data = api_result.data
        else{
            candidate_data = defaultData
            candidate_data.name = uniqueNamesGenerator({
                dictionaries: [starWars]
              })
        }

        const created_data = await cv.create({raw_data:candidate_data,path:req.file.path,fileName:req.file.filename})
        
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
        election = req.body.election
        if(!jwt || !election) res.json({error:"Bad request"})

        cin = await axios.get("http://localhost:7999/auth-service/ValidateJwt",{}, {
            headers: {
              'Authorization': `Bearer ${jwt}` 
            }
          })
        str = JSON.stringify(cin);
        console.log(str); // Logs output to dev tools console.
        //get cin from auth service
        
        //get user data from user service

        //sign the user up for the election

    }

}

module.exports = condidateController