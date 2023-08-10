Books
GET /books: Returns the list of all registered books.
GET /books/{id}: Returns information for a specific book based on the given ID.
POST /books: Adds a new book. Submit the book information in the body of the request, following the format below:
{
   "id": 1,
   "name": "Book Name",
   "isbn": "1234567890123",
   "editor": {
     "id": 1,
     "name": "Publisher Name"
   },
   "category": {
     "id": 1,
     "name": "Category Name",
     "description": "Category Description"
   }
}
PUT /books/{id}: Updates information for an existing book based on the provided ID. Submit the updated information in the body of the request, following the same format as mentioned above.
DELETE /books/{id}: Removes a book from the list based on the given ID.
GET /books/category: Returns the list of books of a given category. Submit the categoryId parameter in the query.
GET /books/publisher: Returns the list of books from a given publisher. Send the editorId parameter in the query.
GET /books/filter: Returns the list of books based on the given name and/or ISBN. Send name and isbn parameters in the query.
Publishers
GET /publishers: Returns the list of all registered publishers.
GET /publishers/{id}: Returns information for a specific publisher based on the given ID.
POST /publishers: Adds a new publisher. Submit publisher information in the body of the request, following the format below:
{
   "id": 1,
   "name": "Publisher Name"
}
PUT /publishers/{id}: Updates information for an existing publisher based on the given ID. Submit the updated information in the body of the request.
DELETE /publishers/{id}: Removes a publisher from the list based on the given ID.
Categories
GET /categories: Returns the list of all registered categories.
GET /categories/{id}: Returns information for a specific category based on the given ID.
POST /categories: Adds a new category. Submit the category information in the body of the request, following the format below:
{
   "id": 1,
   "name": "Category Name",
   "description": "Category Description"
}
PUT /categories/{id}: Updates an existing category's information based on the given ID. Submit the updated information in the body of the request, following the same format as mentioned above.
DELETE /categories/{id}: Removes a category from the list based on the given ID.
Error Handling
The Library API returns appropriate HTTP status codes to indicate the result of a request. In case of an error, a JSON response will be sent, containing an error message and additional details, if applicable.


