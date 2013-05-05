var LibraryView = (function(_, $) {
    var LibraryView = function(options) {
        var el = options.el;
        var libraryRepository = options.libraryRepository;

        var getLibrary = function() {
            libraryRepository.getLibrary(options.libraryId).done(libraryReceived);
        };

        var libraryReceived = function(response) {
            el.find(".books").empty();

            _.each(response.books, function(book) {
                el.find(".books").append("<li>" + book + "</li>");
            });
        };

        getLibrary();
    };

    return LibraryView;
}(_, jQuery));