<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Stagiaire</title>
<link rel="stylesheet" href="./css/Main.css" />
<link rel="stylesheet" href="./css/Bootstrap.css" />

</head>
<body>
	<section class="container">
		<div>
			<form action="ServletPers">

				<div class="form-group row">
					<input type="hidden" name="id" value="${id}" /> 
					<label for="prenom">Prénom</label>
					<input id="prenom" class="form-control" placeholder="Entrer prénom"
						type="text" name="prenom" value="${prenom}" required />
				</div>
				<div class="form-group row">
					<label for="nom">Nom</label> 
					<input id="nom" class="form-control"
						placeholder="Entrer nom" type="text" name="nom" value="${nom}"
						required />
				</div>
				<div class="form-group row">
					<label for="age">Age</label> 
					<input id="age" class="form-control"
						placeholder="Entrer age" type="number" name="age" value="${age}"
						required />
				</div>
				<div class="form-group row">
					<label for="login">Login</label> 
					<input id="login" class="form-control"
						placeholder="Entrer login" type="text" name="login" value="${login}"
						required />
				</div>
				<div class="form-group row">
					<label for="mdp">Mot de passe</label> 
					<input id="mdp" class="form-control"
						placeholder="Entrer mot de passe" type="password" name="mdp" value="${mdp}"
						required />
				</div>
				<div class="bar">
					<button type="submit" class="btn btn-primary" name="modifier"
						value="Modifier">Modifier</button>
				</div>
				<div class="bar">
					<button type="submit" class="btn btn-primary" name="ajouter"
						value="Ajouter">Ajouter</button>
				</div>

				<select name="adresse">
					<optgroup>
						<option value="0">---</option>
						<c:if test="${! empty adresse}">
							<c:forEach items="${adresse}" var="a">
								<option value="${a.idadresse}"><c:out
										value="${a.numRue} ${a.nomRue} ${a.ville} ${a.cp}"></c:out></option>
							</c:forEach>
						</c:if>
					</optgroup>
				</select>


			</form>
		</div>
	</section>
	<section class="container">
		<h2>Liste des personnes</h2>
		<table class="table">
			<thead> 
				<tr>
					<td>ID</td>
					<td>Nom</td>
					<td>Prénom</td>
					<td>Age</td>
					<td>Login</td>
					<td>Mot de passe</td>
					<td>Modifier</td>
					<td>Supprimer</td>
				</tr>
			</thead>
			<tbody>
				<c:if test="${! empty personne}">
					<c:forEach items="${personne}" var="x">
						<tr>
							<td><c:out value="${x.id}" /></td>
							<td><c:out value="${x.nom}" /></td>
							<td><c:out value="${x.prenom}" /></td>
							<td><c:out value="${x.age}" /></td>
							<td><c:out value="${x.connexion.login}" /></td>
							<td><c:out value="${x.connexion.mdp}" /></td>
							<td><a href="ModifierPers?id=${x.id}">Modifier</a></td>
							<td><a href="SupprimerPers?id=${x.id}">Supprimer</a></td>

						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</section>
</body>
</html>