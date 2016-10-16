$(document)
		.ready(
				function() {
					var retriever;
					var msg;
					doRequest();
					// chose user for chat
					$(document).on('click', '.b', function() {
						retriever = $(this).val();
						setInterval(function() {
							getMass(retriever);
						}, 1500);
					})

					// chose msg for delete
					$(document).on('click', '.del', function() {
						var del = $(this).val();
						deleteMass(del);
					});
					// add massage to retriever
					$("#send")
							.click(
									function() {
										$("#friend").append(
												"</br> you:"
														+ $("#textarea").val());
										msg = $("#textarea").val();
										$("#textarea").val("");
										$
												.ajax({
													type : 'POST',
													contentType : 'text/plain',
													url : 'http://localhost:8080/Chat/api/addMass/'
															+ retriever,
													dataType : "text",
													async : false,
													data : msg,
													success : function(data) {
													},
													error : function(data) {
														alert('addmsg error: ');
													}
												});
									})

					var pos = $("#textarea").offset();
					$("#textarea").css({
						"z-index" : "10",
						"font-family" : "Times New Roman",
						"color" : "blue"
					})
					// css
					$("#table").css({
						"z-index" : "500",
						position : "absolute",
						// "background-image" :
						// "url('http://c.dryicons.com/images/icon_sets/architecture_blueprint_icons_set/png/512x512/chat.png')","top"
						// : "15px",
						"background-color" : "#9932CC",
						"font-size" : "4px",
						"font-family" : "Times New Roman",
						"left" : "300px",
						"right" : "450px",
						"bottom" : "70px",
						"padding" : "3px",
						'border' : '3px solid blue',
						'height' : "12px",
						"width" : "20px",
						"margin-top" : "15px",
						"margin-left" : "300px",
						"margin-buttom" : "10px",
						"overflow-y" : "scroll"
					})
					$("td").css({
						"width" : "10px",
						"font-size" : "4px",
						"font-family" : "Times New Roman",
						"color" : "white"
					});
					$("#friend").css({
						"margin-right" : "280px",
						'color' : "black",
						'border' : '3px solid black',
						"font-size" : "8px",
						"font-family" : "Times New Roman",
						"overflow-y" : "scroll"
					});
					$(".del").css({
						"background-color" : "blue",
						"color" : "red"
					})

					$("#chatbox")
							.css(
									{
										'border' : '3px solid black',
										"background-image" : "url('http://c.dryicons.com/images/icon_sets/architecture_blueprint_icons_set/png/512x512/chat.png')",
										"font-family" : "Times New Roman",
										"color" : "black",
										"padding" : "6px",
										'border' : '3px solid black',
										"height" : "600px",
									});
					$("#v").css({
						"color" : "red"
					});
					function getMass(retriever) {
						$
								.ajax({
									url : 'http://localhost:8080/Chat/api/getMassage/'
											+ retriever,
									type : "GET",
									dataType : "json",
									success : function(data) {
										var msg = JSON.stringify(data);
										$("#friend").html("");
										$(jQuery.parseJSON(msg))
												.each(
														function() {
															var sender = this.userSender.username;
															$("#friend")
																	.append(
																			'.'
																					+ sender
																					+ ': '
																					+ this.msg
																					+ '   date:'
																					+ this.date
																					+ ' '
																					+ '<button class="del" value='
																					+ this.id
																					+ '>delete</button> <br>');

														})
									},
									error : function(data) {

									}
								});
					}

					function deleteMass(del) {
						var delw = del

						alert('addmsg : ' + del)
						$.ajax({
							url : 'http://localhost:8080/Chat/api/deleteMass/'
									+ del,
							type : 'DELETE',
							dataType : 'text/plain',
							success : function(data) {
							},
							error : function(data) {
							}
						});
					}

					function doRequest() {
						$
								.ajax({
									url : 'http://localhost:8080/Chat/api/users',
									type : "GET",
									dataType : "json",
									success : function(data) {
										var users = JSON.stringify(data);
										$("#table").html("");
										$(jQuery.parseJSON(users))
												.each(
														function() {
															$("#table")
																	.append(
																			'<tr><td>chat with</td><td><h1>'
																					+ this.username
																					+ '</td>'
																					+ '<td><button class='
																					+ "b"
																					+ ' value='
																					+ this.username
																					+ '>'
																					+ this.username
																					+ '</td></tr>')
														});
									},
									error : function(data) {

									}

								});
					}
				})
