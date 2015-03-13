<h1>Event service</h1>
<h2>Purpose of this service</h2>
<p>Expose endpoints for a RESTFUL webservice for CRUD (Create, Read, Update and Delete) operations on events.</p>
<p>This webservice will accept json and xml, it will also support json and xml responses.</p>

<h2>Endpoints</h2>
<h3>/events</p>
<ul>
  <li><code>GET</code>: Fetch all events</li>
  <li><code>POST</code>: Create a new event</li>
</ul>
<h3>/events/{0}</h3>
<ul>
  <li><code>GET</code>: Fetch a specific event where {0} is the ID of the event.</li>
  <li><code>PUT</code>: Update a specific event where {0} is the ID of the event.</li>
  <li><code>DELETE</code>: Update a specific event where {0} is the ID of the event.</li>
</ul>
<h2>About this service</h2>
<p>This service is made using Grails (Groovy on rails), version 2.4.4.</p>
<h3>How to use</h3>
<ul>
  <li>Download Grails 2.X</li>
  <li>Use the gradle wrapper to build the Grails project</li>
  <li>Run the Grails application with</li>
</ul>
