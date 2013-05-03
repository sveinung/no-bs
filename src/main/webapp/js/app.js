(function($, LibraryView, LibraryRepository) {
    $(function() {
        var libraryView = new LibraryView({
            el: $(".library"),
            libraryRepository: LibraryRepository()
        });
    });
}(jQuery, LibraryView, LibraryRepository));