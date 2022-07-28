import {AddItems} from "./AddItems.js";
import {EditItems} from "./EditItems.js";

let contactBtn = document.getElementById("contact");
let contactInfo = document.getElementById("contact-info");

contactBtn.addEventListener("click", editContactInfo);

function editContactInfo() {
        if (contactInfo.style.display === "none") {
            contactInfo.style.display = "block";
        } else {
            contactInfo.style.display = "none";
        }
}
/*-----------------------ADD ITEMS--------------------------------*/
AddItems();


/*------------------------EDIT ITEMS-------------------------------*/
EditItems();
