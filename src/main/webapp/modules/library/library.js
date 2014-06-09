define(function(require) {

    var Backbone = require('backbone'),

        Book = require('./books/book');

    var Library = Backbone.Collection.extend({
        url: 'http://localhost:8080/rest/library',

        model: Book,

        parse: function(response) {
            return response.books;
        }
    });

    return Library;
});
