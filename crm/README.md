SMS REST API for Java using Spring Edge
================================

This repository contains A Java RestAPI package to send sms using Spring Edge (https://www.springedge.com) APIs

Requirements
------------

- [Sign up](https://www.springedge.com/) for a free Trail Messaging account
- Create a new `apikey` from developers section of sms account
- Setup sender name for sms account.
- Java environment setup.


Installation
------------

Place `smsapi.java` in same directory.
Get API key and Sender name.


Usage
-----
Example of sending message:

```
import com.smsapi;
import java.util.*;

public class test {

	public static void main(String[] args)throws Exception{

		string apikey = "675031xxxxxxxxxxxx"
		string sender = "SEDEMO"

		smsapi s = new smsapi();		
		s.setparams(apikey, sender);
		       
		String response = s.send_sms("98xxxxxxxx","Hello, This is a test message from spring edge");
		System.out.println(response);
	    }
}
```

//Result (Success):
```
{
  "groupID":xxxx,
  "MessageIDs":"xxxxx-x",
  "status":"AWAITED-DLR"
}
```

Or in case of an error:

```javascript
{
  "error":"Invalid Mobile Numbers"
}
```


Support
-------------

For any support or instructions please visit below website:
[https://www.springedge.com](https://www.springedge.com)
