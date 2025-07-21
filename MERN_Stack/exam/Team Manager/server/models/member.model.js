const mongoose = require('mongoose');
const validateEmail = function(email) {
    var re = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    return re.test(email)
};
const memberSchema = new mongoose.Schema({

    name: {
        type: String,
        required: [true, 'name is required'],
        min:[5,"name must be more than one"]
    },
    email: {
        type: String,
        trim: true,
        lowercase: true,
        unique: true,
        required: 'Email address is required',
        validate: [validateEmail, 'Please fill a valid email address'],
        match: [/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/, 'Please fill a valid email address']
    },
    gender:{
        type:String,
        enum:['Male','Female','Unspecified'],
        default:'Unspecified'
    },
    details:{
        type:String,
        min:[20,'details needs to be above 20 characters']
    },
    attendance:{
        type:Boolean,
        default:false
    }
    
}, { timestamps: true });

module.exports = mongoose.model('Member', memberSchema);