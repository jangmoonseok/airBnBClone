$(function(){
	
	/* searchBar toggle */
	const searchBar = document.querySelector('.searchBar');
	
	$('#filterSearch_toggle').click(function(){
		searchBar.classList.add('show');
	})
	
	$('.searchBtn2').click(function(){
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
	
	
	/* price slider */
	const priceSlider = document.querySelector('#filter_price_select');
	const priceSliderBtn = document.querySelector('#filterPriceBtn');
	
	const togglePriceSlider = () => {
		priceSlider.style.display = (priceSlider.style.display != 'none') ? 'none' : 'block';
	}
	
	priceSliderBtn.addEventListener('click', togglePriceSlider);
	
	
	
	const inputLeft = document.getElementById("input-left");
	const inputRight = document.getElementById("input-right");
	
	const thumbLeft = document.querySelector(".thumb.left");
	const thumbRight = document.querySelector(".thumb.right");
	
	const range = document.querySelector(".range");
	
	$('#minPrice').text(inputLeft.value);
	$('#maxPrice').text(inputRight.value);
	
	const setLeftValue = e => {
	  const _this = e.target;
	  const { value, min, max } = _this;
	
	  if (+inputRight.value - +value < 10) {
	    _this.value = +inputRight.value - 10;
	  }
	
	  const percent = ((+_this.value - +min) / (+max - +min)) * 100;
	
	  thumbLeft.style.left = `${percent}%`;
	  range.style.left = `${percent}%`;
	  $('#minPrice').text(_this.value);
	};
	
	const setRightValue = e => {
	  const _this = e.target;
	  const { value, min, max } = _this;
	
	  if (+value - +inputLeft.value < 10) {
	    _this.value = +inputLeft.value + 10;
	  }
	
	  const percent = ((+_this.value - +min) / (+max - +min)) * 100;
	
	  thumbRight.style.right = `${100 - percent}%`;
	  range.style.right = `${100 - percent}%`;
	  
	  $('#maxPrice').text(_this.value);
	};
	
	if (inputLeft && inputRight) {
	  inputLeft.addEventListener("input", setLeftValue);
	  inputRight.addEventListener("input", setRightValue);
	}
	
	/* filter Type */
	const filterTypeBtn = document.querySelector('#filterTypeBtn');
	const filterType = document.querySelector('#filter_type_select');
	
	const toggleFilterType = () => {
		filterType.style.display = (filterType.style.display != 'none') ? 'none' : 'block';
	}

	filterTypeBtn.addEventListener('click', toggleFilterType);
	

	

})