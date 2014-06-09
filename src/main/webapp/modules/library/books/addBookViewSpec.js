define(function(require) {
    var sinon = require('sinon');

    var AddBookView = require('modules/library/books/addBookView');
    var Genres = require('modules/library/books/genres');
    var Book = require('modules/library/books/book');

    var addBookViewPageObject = require('modules/library/books/addBookViewPageObject');

    describe('AddBookView', function() {
        it('hides the view when cancelling', function() {
            var addBookView = createAddBookView();
            addBookView.render();

            addBookViewPageObject(addBookView.$el).
                expectToBeVisible().
                cancel().
                expectToBeHidden();
        });

        it('saves the book', function() {
            var addBookView = createAddBookView({ genres: ["Picaresco"] });
            addBookView.render();

            addBookViewPageObject(addBookView.$el).
                author("Miguel de Cervantes Saavedra").
                title("Don Quixote").
                genre("Picaresco").
                save().
                expectToHaveSaved({
                    author: "Miguel de Cervantes Saavedra",
                    title: "Don Quixote",
                    genre: "Picaresco"
                });
        });
    });

    function createAddBookView(options) {
        options = options || {};

        var genres = [];
        if (options.genres) {
            genres = _.map(options.genres, function(genre) {
                return { name: genre }
            });
        }

        return new AddBookView({
            genres: new Genres(genres),
            book: new Book()
        });
    }
});
