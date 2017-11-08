package bvb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bvb.user
import bvb.Constants
import bvb.BCrypt

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    // get current, new password from input and encrypt it 
    String inputCurrentPassword = null;
    if(request.getParameter("inputCurrentPassword")!=null) 
    {
        inputCurrentPassword = BCrypt.hashpw(request.getParameter("inputCurrentPassword"));   
    };

    String inputPassword = null;
    if(request.getParameter("inputPassword")!=null) 
    {
        inputPassword = BCrypt.hashpw(request.getParameter("inputPassword")); 
    };
    
    // get user id from session
    Integer userId = (Integer) request.getSession().getAttribute(Constants.USER);
    public static Status sp = new Status();
    
    try 
    {
        if(userId!=null && inputCurrentPassword != null) 
        {
            if(userid.verifyUserIdAndPassword(userId.toString(), inputCurrentPassword)) 
            {
                
                // update password if current password matches
                userid.updatePassword(userId.toString(), inputPassword);
                sp.setMessage("Super! Sie haben Ihr Passwort geändert!");
            } 

            else 
            {
                sp.setMessage("Die aktuelle Passwort stimmt nicht. Versuchen Sie es erneut!");
            }   
        } 

        else 
        {
            sp.setMessage("Falscher input");
        }
    } 
}
