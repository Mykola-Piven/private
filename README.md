VOTING SYSTEM

Voting System is application to deciding where to have a lunch.
Application is used by two types of users:
1. Admins - input info about restaurants and lunch menus of day (should be new menu for each day, up to 5 dishes).
2. Users - vote on which restaurant they want to have a lunch. Only one vote from one user is possible. 
   If User changes his mind, he be able vote againe till 11:00.
   
URL:
1. To diplay lunch menu (request type GET):
	/admin/lunch or /admin/lunch?restaurant=:restaurant_name 
	/user/lunch or /user/lunch?restaurant=:restaurant_name 
	Example: /user/lunch
			/user/lunch?restaurant=Pizza Celentano
			
	curl -v -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://localhost:8080/admin/lunch
	curl -v -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://localhost:8080/admin/lunch?restaurant=Pizza Celentano
	curl -v -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://localhost:8080/user/lunch
	curl -v -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://localhost:8080/user/lunch?restaurant=Pizza Celentano


2. To display vote statistic for current day (request type GET):
	/admin/vote
	/user/vote

	curl -v -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://localhost:8080/admin/vote
	curl -v -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://localhost:8080/user/vote

	
3. To add lunch menu (request type POST):
	/admin/lunch 
	body should be in following format:
	<restoran name>,<date formatted as DD/MM/YYYY>,[<dish name 1>,<price 1>;<dish name 2>,<price 2>;...;<dish name 5>,<price 5>]
	Example: Subway,05/11/2015,[Sandwiches,25.99;Salads,5.99;Sides,1.99;Drinks,3.99]

	curl -v -H "Accept: application/json" -H "Content-Type: application/json" -X POST http://localhost:8080/admin/lunch -d '{ Subway,05/11/2015,[Sandwiches,25.99;Salads,5.99;Sides,1.99;Drinks,3.99] }'	 
	
4. To vote (request type POST):
	/user/vote
	body should be in following format:
	<restoran id>,<user name>
	Example: 1,Mr.Smith

	curl -v -H "Accept: application/json" -H "Content-Type: application/json" -X POST http://localhost:8080/user/vote -d '{ 1,Mr.Smith }'

	
SUCCESS RESPONSES:
1. To diplay lunch menu
Example: 
Code: 200 
Content: 
{
	response: {
		lunch_menu: [{
			restoran_id: "1",
			restoran_name: "Pizza Celentano",
			date: "05/11/2015",
			dish: [{
				name: "Vinegret",
				price: "11.99"
			},
			{
				name: "Pizza Margarita",
				price: "55.5"
			},
			{
				name: "Blinie",
				price: "10.0"
			},
			{
				name: "Sauce Caesar",
				price: "2.99"
			},
			{
				name: "Black Tea",
				price: "1.5"
			}]
		}]
	}
}

2. To display vote statistic for current day:
Example: 
Code: 200 
Content:
{
	response: {
		vote_results: [{
			restoran_name: "Pizza Celentano",
			vote_number: "1"
		},
		{
			restoran_name: "Odessa",
			vote_number: "0"
		},
		{
			restoran_name: "Subway",
			vote_number: "0"
		}]
	}
}

3. To add lunch menu:
Example: 
Code: 200 
Content: Lunch Menu is created Successfully

4. To vote:
Example: 
Code: 200 
Content: Your vote is ACCEPTED


ERROR RESPONSE:
1. To add lunch menu:
Example: 
Code: 500 Internal Server Error 
Content:
{
	timestamp: 1446728451676
	status: 500
	error: "Internal Server Error"
	exception: "java.lang.NumberFormatException"
	message: "For input string: "WRONG_PRICE""
	path: "/admin/lunch"
}

2. To vote:
Example: 
Code: 200 
Content: Your vote is NOT ACCEPTED, because Your have been voted today

Code: 200 
Content: Your vote is NOT ACCEPTED, because Current restaurant is absend
	 
