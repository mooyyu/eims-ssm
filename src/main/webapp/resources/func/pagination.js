var curpage = 1;
var peritem = 20;
var sumpages = Math.ceil(itemlistsize / peritem);

var paginationapp = new Vue({
    el: "div#main",
    data: {
        next_page: "",
        prev_page: "",
        link_1: -1,
        link_2: 0,
        link_3: 1,
        link_4: 2,
        link_5: 3
    },
    methods: {
        nextpage: function() {
            for (i = (curpage - 1) * peritem + 1; i <= Math.min(curpage * peritem, itemlistsize); i++) {
                $("tr#" + i).addClass("d-none");
            }
            curpage++;
            this.updatepagelink();
            for (i = (curpage - 1) * peritem + 1; i <= Math.min(curpage * peritem, itemlistsize); i++) {
                $("tr#" + i).removeClass("d-none");
            }
            this.checkcurpage();
            this.check_link();
        },
        prevpage: function() {
            for (i = (curpage - 1) * peritem + 1; i <= Math.min(curpage * peritem, itemlistsize); i++) {
                $("tr#" + i).addClass("d-none");
            }
            curpage--;
            this.updatepagelink();
            for (i = (curpage - 1) * peritem + 1; i <= Math.min(curpage * peritem, itemlistsize); i++) {
                $("tr#" + i).removeClass("d-none");
            }
            this.checkcurpage();
            this.check_link();
        },
        checkcurpage: function() {
            if (curpage == 1) {
                this.prev_page = "page-item disabled";
            } else {
                this.prev_page = "page-item";
            }
            if (curpage == sumpages) {
                this.next_page = "page-item disabled";
            } else {
                this.next_page = "page-item";
            }
        },
        page_link: function(idx) {
            for (i = (curpage - 1) * peritem + 1; i <= Math.min(curpage * peritem, itemlistsize); i++) {
                $("tr#" + i).addClass("d-none");
            }
            curpage += idx;
            this.updatepagelink();
            for (i = (curpage - 1) * peritem + 1; i <= Math.min(curpage * peritem, itemlistsize); i++) {
                $("tr#" + i).removeClass("d-none");
            }
            this.checkcurpage();
            this.check_link();
        },
        check_link: function() {
            if (this.link_1 < 1) {
                $("li#link_1").addClass("d-none");
            } else {
                $("li#link_1").removeClass("d-none");
            }
            if (this.link_2 < 1) {
                $("li#link_2").addClass("d-none");
            } else {
                $("li#link_2").removeClass("d-none");
            }
            if (this.link_4 > sumpages) {
                $("li#link_4").addClass("d-none");
            } else {
                $("li#link_4").removeClass("d-none");
            }
            if (this.link_5 > sumpages) {
                $("li#link_5").addClass("d-none");
            } else {
                $("li#link_5").removeClass("d-none");
            }
        },
        updatepagelink: function() {
            this.link_1 = curpage - 2;
            this.link_2 = curpage - 1;
            this.link_3 = curpage;
            this.link_4 = curpage + 1;
            this.link_5 = curpage + 2;
        }
    }
});

for (i = 1; i <= Math.min(peritem, itemlistsize); i++) {
    $("tr#" + i).removeClass("d-none");
}
if (sumpages < 2) {
    $('nav#paginationBar').addClass("d-none");
} else {
    paginationapp.check_link();
    paginationapp.checkcurpage();
}
