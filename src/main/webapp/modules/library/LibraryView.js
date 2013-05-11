define(function(require) {

    var _ = require('underscore'),
        template = require('text!./libraryView.mustache'),
        mustache = require('mustache');

    var LibraryView = function(options) {
        var el = options.el;
        var libraryRepository = options.libraryRepository;

        var getLibrary = function() {
            libraryRepository.getLibrary(options.libraryId).done(libraryReceived);
        };

        var libraryReceived = function(response) {
            el.find(".books").empty();

            _.each(response.books, function(book) {
                el.find(".books").append("<li>" + book.title + "</li>");
            });
        };

        var render = function() {
            el.html(mustache.render(template));

            el.find(".add-book").click(function(event) {
                event.preventDefault();
                el.find(".book-input-form").show();
            });

            getLibrary();
        };

        return {
            render: render
        }
    };

    return LibraryView;
});