require(['library/libraryView', 'library/libraryRepository'], function(LibraryView, LibraryRepository) {

    $(function() {
        var libraryView = LibraryView({
            el: $(".library"),
            libraryId: 1,
            libraryRepository: LibraryRepository()
        });
        libraryView.render();
    });
});