(function($, LibraryView, LibraryRepository) {
    $(function() {
        var libraryView = new LibraryView({
            el: $(".library"),
            libraryRepository: new LibraryRepository()
        });
    });
}(jQuery, LibraryView, LibraryRepository));