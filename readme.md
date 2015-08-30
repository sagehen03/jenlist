Shopping List App (JenList)

**** RESTish API ****

verb,endpoint,request body,function,response
GET,/shopping-list/{id},none,gets all shopping list items in list with {id},[{"name":"apricots","comment":"quantity 5","createdAt":"2015-08-30","completed":false,"shoppingListId":2,"id":5}] 
GET,/shopping-list,none,gets all shopping lists,[{"id":1,"name":"Whole Foods List","createdAt":"2015-08-30"}]
POST,/shopping-list/{newListName},none,creates new list with name {newListName},HTTP status code
POST,/shopping-list,[{"name":"Green Beans","comment":"half pound","completed":false,"shoppingListId":1}],adds new items to a shopping list,HTTP status code
DELETE,/shopping-list,[{"name":"Green Beans","comment":"half pound","completed":false,"shoppingListId":1, "id": 4}],removes items from a shopping list,HTTP status code
GET,/master-list,none,retrieves items in master list,[{"id":1,"name":"Tomatoes"},{"id":2,"name":"Green Beans"},{"id":3,"name":"Dog Treats"}]
POST,/master-list,{"name": "Tomatoes"},adds an item to the master list, HTTP status code
DELETE,/master-list{id},none,deletes the item with the specified id from the master list, HTTP status code


