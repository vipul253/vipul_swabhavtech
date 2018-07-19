<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String username = "Guest";
	String role = "";
	boolean loggedIn = false;

	if (request.getSession().getAttribute("name") != null) {
		username = (String) session.getAttribute("name");
		role = (String) session.getAttribute("role");
		loggedIn = true;
	}
%>
<header>
	<nav class="navbar navbar-expand-md navbar-dark bg-dark">
		<a class="navbar-brand" href="">Sample Bank</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navList" aria-controls="navList" aria-expanded="true"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navList">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="">Home
				</a></li>
				<%
					if (role=="user") {
				%>
				<li class="nav-item"><a class="nav-link" href="makeCSV">Get
						CSV</a></li>
				<li class="nav-item"><a class="nav-link" href="makeTransaction">Make
						Transaction</a></li>

				<%
					}
				%>
			</ul>
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" href=""> <i
						class="fa fa-user" aria-hidden="true"></i> <%=username%>
				</a></li>
				<%
					if (loggedIn) {
				%>
				<li class="nav-item"><a class="nav-link"
					href="<s:url action="logout"/>"><i class="fa fa-sign-out"
						aria-hidden="true"></i> Logout</a></li>
				<%
					} else {
				%>
				<li class="nav-item"><a class="nav-link"
					href='<s:url action="register"/>'><i class="fa fa-user-plus"
						aria-hidden="true"></i> Register</a></li>
				<li class="nav-item"><a class="nav-link"
					href='<s:url action="login"/>'><i class="fa fa-sign-in"
						aria-hidden="true"></i> Login</a></li>
				<%
					}
				%>
			</ul>
		</div>
	</nav>
</header>