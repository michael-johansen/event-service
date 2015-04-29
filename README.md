<h1>Event service</h1>
<h2>Purpose of this service</h2>
<p>Expose endpoints for a RESTFUL webservice for CRUD (Create, Read, Update and Delete) operations on events.</p>
<p>This webservice will accept json and xml, it will also support json and xml responses.</p>

<h2>Endpoints</h2>
<h3>/</h3>
<ul>
  <li><code>GET</code>: Fetch all events (accepts three parameters, <code>max</code> which sets the max amount of desired results. <code>intervalStart</code> and <code>intervalEnd</code> which in combination sets the datetime interval for desired results.</li>
  <li><code>POST</code>: Create a new event</li>
</ul>
<p>Example of valid json to post, remember the <code>Content-Type</code> header <code>application/json</code></p>
```json
{
	"name": "Partytime",
	"description": "The greatest party in the history of mankind!",
	"startDate": "1430290662045",
	"endDate": "1430290662045",
	"location": 7,
	"users": [1,2,3,4]
}
```

<h3>/{0}</h3>
<ul>
  <li><code>GET</code>: Fetch a specific event where {0} is the ID of the event.</li>
  <li><code>PUT</code>: Update a specific event where {0} is the ID of the event.</li>
  <li><code>DELETE</code>: Update a specific event where {0} is the ID of the event.</li>
</ul>
<h2>About this service</h2>
<p>This service is made using Grails (Groovy on rails), version 2.4.4.</p>
<h3>How to run the application in development mode</h3>
<ul>
  <li>Download the zip and extract, or clone this repository</li>
  <li>Navigate to the repository and run <code>./grailsw run-app</code> (linux/mac) or <code>grailsw run-app</code> (windows)
</ul>
