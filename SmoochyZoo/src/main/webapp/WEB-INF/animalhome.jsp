<h1>Welcome To Smoochy Zoo!</h1>

	<strong>Get a list of all the animals in the Zoo</strong>
		<br>
		<br>
		<form action="getAllAnimals.do" method="GET">
	  		<input type="submit" value="Show a list of all the Animals in the Zoo" />
		</form>
		<br>
		<br>
		<strong>Find the Animal by it's id</strong>
		<br>
		<br>
			<form action="getAnimalById.do" method="GET">
	 		 Needle ID: <input type="number" name="animal" />
	  		<input type="submit" value="Show Animal" />
		</form>
		<strong>Find the Animals by the name provided</strong>
		<br>
		<br>
		<form action="getAllAnimalsByName.do" method="GET">
	 		 Needle ID: <input type="text" name="name" />
	  		<input type="submit" value="Show Animals with the name provided" />
		</form>
		<br>
		<br>
		<strong>Find the Animals by their species</strong>
		<br>
		<br>
		<form action="getAllAnimalsBySpecies.do" method="GET">
	 		 Needle ID: <input type="text" name="species" />
	  		<input type="submit" value="Show Animals with the species provided" />
		</form>
		<br>
		<br>
		<strong>Find the Animals by their category</strong>
		<br>
		<br>
			<form action="getAnimalByCategory.do" method="GET">
	 		 Needle ID: <input type="text" name="category" />
	  		<input type="submit" value="Show Animals with the category provided" />
		</form>
