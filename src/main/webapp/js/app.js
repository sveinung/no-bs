(function($, LibraryView, LibraryRepository) {
    $(function() {
        var libraryView = LibraryView({
            el: $(".library"),
            libraryRepository: LibraryRepository()
        });
    });
}(jQuery, LibraryView, LibraryRepository));