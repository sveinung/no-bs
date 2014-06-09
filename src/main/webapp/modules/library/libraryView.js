define(function(require) {

    var _ = require('underscore');
    var BaseView = require('base/view');

    var template = require('text!./libraryView.mustache');

    var AddBookView = require('./books/addBookView');
    var Genres = require('./books/genres');
    var Book = require('./books/book');

    var LibraryView = BaseView.extend({
        events: {
            'click .add-book': 'addBookClicked'
        },

        initialize: function(options) {
            this.library = options.library;

            this.genres = new Genres();
            var book = new Book();
            this.addBookView = new AddBookView({
                genres: this.genres,
                book: book
            });
            this.listenTo(this.addBookView, "book:added", this.bookAdded);
            this.listenTo(this.library, "add", this.render);
        },

        render: function() {
            this.renderTemplate(template, {
                books: this.library.toJSON()
            });
            return this;
        },

        addBookClicked: function(event) {
            event.preventDefault();

            this.addBookView.setElement(this.$('.add-book-view'));

            this.genres.fetch().done(_.bind(this.genresReceived, this));
        },

        genresReceived: function() {
            this.addBookView.render();
            this.addBookView.show();
        },

        bookAdded: function(book) {
            this.library.add(book);
        }
    });

    return LibraryView;
});
