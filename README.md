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
<h3>/{0}</h3>
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
  <li>The application expects a MySQL database on localhost called <code>event_service_development</code> with user <code>root</code> and password <code>mysecretpassword</code>
  <li>Run the Grails application with<code>Grails run-app</code></li>
</ul>
