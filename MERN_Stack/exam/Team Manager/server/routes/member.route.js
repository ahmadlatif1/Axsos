
const MemberController = require("../controllers/member.controller");

module.exports = (app) => {
    app.post("/api/member", MemberController.createMember);
    app.get("/api/members", MemberController.getAllMembers);
    app.get("/api/member/:id", MemberController.getMember);
    app.patch("/api/member/:id", MemberController.updateMember);
    app.delete("/api/member/:id", MemberController.deleteMember);
};

