
$(document)
		.ready(
				function() {

					$("body")
							.css(
									{
										"background-image" : "url('http://cdn.wallpapersafari.com/65/14/YxVJHN.jpg')"
									});

					$("#head")
							.css(
									{
										"background-image" : "url('http://www.dvd-ppt-slideshow.com/blog/wp-content/uploads/2010/09/digital_universe_55.jpg')",
										"font-weight" : "10",
										"font-size" : "100px",
										"text-align" : "center",
										"font-family" : "Times New Roman",
										"border" : "3px solid black"
									});
					$("#b").click(function() {
						alert("Handler for .click() called.");
					});
					// $("#form").css({'border':'3px solid
					// black',"height":"300px","margin-top":
					// "100px","margin-left": "200px","margin-right":
					// "200px","margin-buttom": "500px"})
					$("#table").css({
						"font-size" : "1px",
						"padding" : "6px",
						'border' : '3px solid black',
						"height" : "300px",
						"weight" : "150px",
						"margin-top" : "100px",
						"margin-left" : "200px",
						"margin-right" : "200px",
						"margin-buttom" : "500px"
					})
					$("td").css({
						"font-family" : "Times New Roman",
						"fontSize" : " 50",
						"color" : "white"
					})
					$("#submit")
							.click(
									function() {
										
										$
												.ajax({
													type : 'POST',
													contentType : 'application/json',
													url : 'http://localhost:8080/Chat/api/addUser',
													dataType : "text",
													async : false,
													data : '   {'
															+ '   "id": 1,'
															+ '   "username": "'+$("#username").val()+'", '
															+ '   "town": {'
															+ '   "name": "'+$("#town").val()+'",   '
															+ '    "id": 1      '
															+ ' },'
															+ '   "gender": {'
															+ '      "name": "'+$("#gender").val()+'",'
															+ '      "id": 1'
															+ '   },                 '
															+ '    "password": "'+$("#password").val()+'"   '
															+ '}',
													success : function(data) {
														alert('created successfully');
														window.location.href = "/http://localhost:8080/Chat/chatArea.html"
														

													},
													error : function(data) {
														alert('addWine error: '
																+ JSON
																		.stringify(data));
													}
												});
									
										
									});

				});
