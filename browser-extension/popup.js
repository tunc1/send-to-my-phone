const readCookie=name=>
{
	if(document.cookie.includes(name+"="))
	{
		var tmp=document.cookie.substring(document.cookie.indexOf(name+"=")+1+name.length);
		if(tmp.includes(";"))
			return tmp.substring(0,tmp.indexOf(";"));
		return tmp;
	}
	return null;
};
const COOKIE_NAME="send-to-my-phone-id";
document.addEventListener('DOMContentLoaded', function()
{
	const id=readCookie(COOKIE_NAME);
	if(id!=null)
		document.getElementById("currentIdP").innerHTML=id;
	else
		document.getElementById("currentIdP").innerHTML="Not Entered Any";
	document.getElementById("logOutButton").onclick=()=>document.cookie=COOKIE_NAME+"=0;expires=Thu, 01 Jan 1970 00:00:01 GMT";
});