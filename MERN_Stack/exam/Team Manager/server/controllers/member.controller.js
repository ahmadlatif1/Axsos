const member = require('../models/member.model');


module.exports.createMember = (req, res) => {
    const { name, email, gender, details } = req.body;

    member.create({ name, email, gender, details })
        .then(member => res.json(member))
        .catch(err => {
            console.error("❌ Error creating member:", err);
            res.status(400).json(err);
        });
}
module.exports.getAllMembers = (request, response) => {
    member.find({})
        .then(members => response.json(members))
        .catch(err => response.json(err))
}

module.exports.getMember = (request, response) => {
    member.findOne({ _id: request.params.id })
        .then(member => response.json(member))
        .catch(err => response.json(err))
}

module.exports.updateMember = (request, response) => {
    member.findOneAndUpdate({_id: request.params.id}, request.body, {new:true})
        .then(updatedMember => response.json(updatedMember))
        .catch(err => response.json(err))
}

module.exports.deleteMember = (request, response) => {
    member.deleteOne({ _id: request.params.id })
        .then(deleteConfirmation => response.json(deleteConfirmation))
        .catch(err => response.json(err))
}