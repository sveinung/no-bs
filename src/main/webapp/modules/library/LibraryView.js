define(function(require) {

    var _ = require('underscore');

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

        return {
            render: getLibrary
        }
    };

    return LibraryView;
});