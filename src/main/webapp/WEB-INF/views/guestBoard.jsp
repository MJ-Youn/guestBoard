<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js" ></script>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/guestBoard.css"/>
		<script src="${pageContext.request.contextPath}/resource/js/guestBoard.js"></script>
	</head>
	<body>
		<h1 id="main_title">
			Guest Board
		</h1>
		<div id="main_frame">
			<div class="board_form">
				<form>
					<input type="email" class="form-control input_form" placeholder="Enter email" />
					<input type="password" class="form-control input_form" placeholder="Enter password" />
					<input type="submit" class="btn btn-success" value="Submit" />
					<textarea rows="3" cols="115" class="textarea" placeholder="Enter Contents"></textarea>
				</form>
			</div>
			<div class="contents_list">
				<%-- <c:forEach items="${list}" var="dto">
					<div class="contents" id="${dto.IDX }">
						<form>
							<p class="email">${dto.EMAIL }</p>
							<input type="password" class="form-control input_form modify_hidden" placeholder="Enter password" />
							<input type="submit" class="btn btn-success modify_hidden" value="Submit" />
							<input type="button" class="btn btn-info btn-xs modify" value="modify" />
							<p class="time">${dto.POST_TIME }</p>
							<textarea rows="3" cols="115" class="textarea" placeholder="Enter Contents" readonly>${dto.CONTENT }</textarea>
						</form>
					</div>
				</c:forEach> --%>
				<div class="contents" id="1">
					<form>
						<p class="email">yun0244@naver.com</p>
						<input type="password" class="form-control input_form modify_hidden" placeholder="Enter password" />
						<input type="submit" class="btn btn-success modify_hidden" value="Submit" />
						<input type="button" class="btn btn-info btn-xs modify" value="modify" />
						<p class="time">YYYY-MM-DD HH:MM:SS</p>
						<textarea rows="3" cols="115" class="textarea" placeholder="Enter Contents" readonly>Hi! I'm MJ.</textarea>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>