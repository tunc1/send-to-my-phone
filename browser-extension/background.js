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
const URL="http://localhost:8080/text/";
const MAX_LENGTH=9999;
var search=info=>
{
	const id=readCookie(COOKIE_NAME);
	console.log(id);
	if(id!=null)
	{
		const text=info.selectionText;
		if(text.length>MAX_LENGTH)
			text=text.substring(0,MAX_LENGTH);
		const xhr = new XMLHttpRequest();
		xhr.open("PUT", URL+id);
		xhr.setRequestHeader("Content-Type","application/json");
		xhr.send(JSON.stringify({text}));
	}
	else
	{
		const id=prompt("Enter ID:");
		if(id!=null)
			document.cookie=COOKIE_NAME+"="+id;
	}
};
chrome.contextMenus.create(
    {
        title:"Send to My Phone",
        contexts:["selection"],
        onclick: search
    }
)