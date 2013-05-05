(function($, LibraryView, LibraryRepository) {
    $(function() {
        var libraryView = LibraryView({
            el: $(".library"),
            libraryId: 1,
            libraryRepository: LibraryRepository()
        });
    });
}(jQuery, LibraryView, LibraryRepository));