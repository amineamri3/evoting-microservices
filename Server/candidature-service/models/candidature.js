const mongoose = require("mongoose");
const Schema = mongoose.Schema;

const candidateSchema = new Schema(
    {
      Status: String,
      Reason: String,
      ElectionId: String,
    },
    { timestamps: true }
  );
  
  module.exports = mongoose.model("candidature", candidateSchema);
  