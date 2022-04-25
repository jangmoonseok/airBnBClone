$(function(){
	
	$('.searchBtn').click(function(){
		where = $('#where').val().trim();
		checkIn = $('#checkIn').val();
		checkOut = $('#checkOut').val();
		person = 0;

		let animal = $('.animal_count').text();
		
		personCounts = document.getElementsByClassName('person_count')
		
		for(i = 0; i < personCounts.length; i++){
			person += parseInt(personCounts[i].innerText);
		}
		if(where == ""){
			$('#where').focus();
		}else{			
			location.href = "../main/searchProd.jsp?addr=" + where + 
				"&check_in=" + checkIn + "&check_out=" + checkOut +
				"&person=" + person;
		}

	})
})