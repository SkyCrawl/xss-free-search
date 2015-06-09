# Overview

## Technologies used

### Server-side

1. JavaEE
2. [Rythm Template Engine](http://rythmengine.org/)
3. [ESAPI for Java](https://github.com/ESAPI/esapi-java-legacy)
	* Note: a newer version is on the way [here](https://github.com/ESAPI/esapi-java)
4. JAX-RS (RESTful services) + [Jersey](https://jersey.java.net/)

### Client-side

1. Classic HTML/CSS
2. [jQuery](https://jquery.com/)
3. [jQuery Encoder](https://github.com/chrisisbeef/jquery-encoder)

Special attention should be paid to libraries responsible for escaping HTML/CSS/Javascript/URLs because it is the main means of mitigating XSS attacks, until `X-XSS-Protection` and `Content-Security-Policy` headers are properly designed, supported by all major browsers and used in practice.

To that end, we used `ESAPI for Java` on the server and `jQuery Encoder` on the client. As of now, `jQuery Encoder` seems to be the best choice, followed by:
* [Escapist.js](<https://github.com/mstapp/escapist.js)
* [ESAPI for Javascript](https://github.com/ESAPI/owasp-esapi-js)

While `ESAPI for Javascript` may be a little old, it is still one of the best libraries out there because it (as well as ports to other programming languages) originates from the OWASP Reform Project. The same can be said about `Escapist` which is a little more up-to-date and should be a little more user-friendly.

## The project

The initiative of this project is to show how to mitigate (above all) reflected XSS - by escaping all potentially unsafe HTML/CSS/Javascript content. By "potentially unsafe" we meant "potentially coming from users" (whether regular or malicious), even through obscure odds or ends. All user content is to be considered harmful. "User content" is anything except "safe content". "Safe content" is:
* constant data used by your application,
* safe content that passed appropriate safety measures (i.e. HTML escaping) and sanitizations,
* something that is directly generated from safe content by your application whilst giving no chance to anybody to tamper with them.

The above is shown on an example of a search mechanism. Three versions have been implemented:

1. "Pageback"
	* Search returns the whole page in response, causing a browser refresh.
	* Search is requested via a simple HTTP GET request, originated by an HTML form.
2. "Frameback"
	* Search returns only the search results which are embedded into a dedicated `iframe` HTML element.
	* Search is requested via a simple HTTP GET request, originated by an HTML form.
3. "Searchback"
	* Search returns only the search results which are embedded into a dedicated `div` HTML element.
	* Search is requested via a simple HTTP POST request, originated by a jQuery AJAX call.

All versions look identical but they are different on the background.

Each version has its own pros and cons. Each version suffers from the same type of vulnerability, unless server (and possibly client as well) employs a strict escaping policy.

### How to launch

This repository includes a generated `.war` file. Deploy it to a Servlet Container of choice and open the following URLs in your browser, after substituting `localhost:8080` for address to your Servlet Container:
* <http://localhost:8080/xss-free-search/pageback>
* <http://localhost:8080/xss-free-search/frameback>
* <http://localhost:8080/xss-free-search/searchback>

**IMMEDIATELY AFTER LAUNCH, ESCAPING HTML/CSS/JAVASCRIPT IS NOT ENABLED.**  
Each page contains a link to:
* example malicious payloads,
* application settings where escaping can be enabled.

### Page templating

Special attention should be paid to the mechanism that generates pages in this application:

1. Web server (Servlet) constructs a view object dedicated to the type of page we want to return and feeds it with the request data. No escaping is necessary at this point.
2. Web server (Servlet) passes the view object to a templating engine (Rythm in this application) and requests for the page to be generated.
3. The engine uses the passed view object and constructs the appropriate page from it as denoted by the template source file. This is where the escaping takes place - right at the moment of page construction.

Why is this a good solution? Separation of concerns!
* It is much easier to escape everything at the same time rather than do it "somewhere in the application".
* It is easy to spot a variable (user input) that is not properly escaped/sanitized.
* Each variable (user input) can be appropriately escaped "in-place" by the current context (HTML/CSS/Javascript/URL).

Page templates can be found [here](./WebContent) and [here](./WebContent/components).

