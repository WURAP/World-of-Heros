package bvb

import 

import bvb.User
import bvb.Constants
import bvb.Reset
import bvb.BCrypt

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    // get user Id and email verification code Hash code  
    Integer userId = Integer.parseInt(request.getParameter("userId"));
    String hash = BCrypt.hashpw(request.getParameter("hash"), Constants.CODE);
    String scope = request.getParameter("scope");
    String message = null;
    public static User = new User();

    try 
    {

        // verify with database
        if(userid.verifyEmailHash(userId.toString(), hash) && scope.equals(Constants.RESET_PASSWORD)) 
        { 
           //update status as active
           userid.updateStaus(userId.toString(), "active");
           
           //put some session for user
           request.getSession().setAttribute(Constants.USER, userId);
           request.getSession().setAttribute(Constants.IS_RESET_PASSWORD_VERIFIED, Constants.YES);
           
           //forward request to reset password html page
           request.getRequestDispatcher("/WEB-INF/changePassword.html").forward(request, response);  
        } 

        else 
        {
           //now increment verification attempts 
           int attempts = userid.incrementVerificationAttempts(userId.toString());
           if(attempts == 10) 
           {
               // reset verification code if attempts equal to 10 
               String hashcode = Reset.prepareRandomString(30);
               userid.updateEmailVerificationHash(userId.toString(), BCrypt.hashpw(hashcode, Constants.CODE));
               User up = userid.selectUSER(userId.toString());
               message = "Sie haben 10 Mal den falschen Code eingegeben.";
           } 

            else 
            {
               message = "Falscher E-mail input.";   
            }
        }
    } 
}