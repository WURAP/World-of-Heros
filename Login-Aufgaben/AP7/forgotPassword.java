package bvb;

import 

import bvb.user
import bvb.Reset
import bvb.BCrypt
import bvb.Constants

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    // take email from user input
    String inputEmail = request.getParameter("inputEmail");
    public static User = new User();

    try 
    {
        // get user details for given email
        StatusUser up = userid.selectUSERbyEmail(inputEmail); 
        
        if(up!=null) 
        {
            // create verification code
            String hash = Reset.prepareRandomString(30);
            
            // update verification code in database 
            userid.updateEmailVerificationHashForResetPassword(inputEmail, BCrypt.hashpw(hash,Constants.CODE));
            
            // send email to user with verification link
            sp.setMessage("Wir haben Ihnen den Verification Code via E-mail geschickt.");
        } 

        else 
        {
            sp.setMessage("Diese E-mail Adresse existiert nicht!");
        }
    } 
}