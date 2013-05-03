var LibraryView = (function(_, $) {
    var LibraryView = function(options) {
        var el = options.el;
        var libraryRepository = options.libraryRepository;

        var libraryId = function() {
            return el.find(".library-input").val();
        };

        var getLibrary = function() {
            libraryRepository.getLibrary(libraryId()).done(libraryReceived);
        };

        var libraryReceived = function(response) {
            el.find(".books").empty();

            _.each(response.books, function(book) {
                el.find(".books").append("<li>" + book + "</li>");
            });
        };

        el.find(".retrieve-books").click(getLibrary);
    };

    return LibraryView;
}(_, jQuery));