import { listItemProject } from "./Templates/ItemProject.js";
import { listItemEducation } from "./Templates/ItemEducation.js";
import { listItemExperience } from "./Templates/ItemExperience.js";
import { listItemLanguage } from "./Templates/ItemLanguage.js";

function AddItems() {
    function showAddFn(idInputToAdd) {
        if( idInputToAdd.style.display == "none") {
            idInputToAdd.style.display = "block";
        } else {
            idInputToAdd.style.display = "none";
        }
    }
    
    function agregateListItem(idUlToAdd, listItemTemplate, content1, content2, content3, content4, content5, content6, nroList) {
        let ul = document.getElementById(idUlToAdd);
        let ulFirstChild = ul.firstChild;
        let div = document.createElement("div");
        div.innerHTML = listItemTemplate(content1, content2, content3, content4, content5, content6, nroList);
        ul.insertBefore(div, ulFirstChild);
    }
    
    function addInfo(buttonToSave, input1, input2, input3, input4, input5, input6,nroList, template, idInputsToAdd, idUlToAdd) {
        buttonToSave.addEventListener("click", (e) => {
            let var1 = input1.value;
            let var2 = input2.value;
            let var3 = input3.value;
            let var4 = input4.value;
            let var5 = input5.value;
            let var6 = input6.value;
            idInputsToAdd.style.display = "none";
            agregateListItem(idUlToAdd, template, var1, var2, var3, var4, var5, var6, nroList);        
            let inputs = [input1, input2, input3, input4, input5, input6];
       
            inputs.forEach(i => {
                if(i.value) {
                   i.value = "";
                }
            });
        });
    }
    
    
    /*PROJECTS: ADD ITEMS*/
    let listInfoProjects = document.getElementsByClassName("list-info-project");
    let numberOfListProject = listInfoProjects.length + 1; 
    let agregateBtnProjects = document.getElementById("agregate-btn-projects");
    let inputsToAddProjects = document.getElementById("inputsToAddProjectsInfo");
    let inputTitle = document.getElementById("titleInput");
    let inputPlace = document.getElementById("placeInput");
    let inputDescription = document.getElementById("descriptionInput");
    let btnAgregateChangeInProjects = document.getElementById("saveChangesInInputsProjects");
    
    agregateBtnProjects.addEventListener("click", () => {
        showAddFn(inputsToAddProjects);
    });
     
    addInfo(btnAgregateChangeInProjects, inputTitle, inputPlace, inputDescription,"", "", "", numberOfListProject, listItemProject, inputsToAddProjects, "projects");
    
    /*EDUCATION: ADD ITEMS */
    let listInfoEducation = document.getElementsByClassName("list-info-education");
    let numberOfListEducation = listInfoEducation.length + 1; 
    let agregateBtnEducation = document.getElementById("agregate-btn-education");
    let inputsToAddEducation = document.getElementById("inputsToAddEducationInfo");
    let inputCareer = document.getElementById("careerInput");
    let inputPlaceStudies = document.getElementById("placeOfStudiesInput");
    let inputDateStart = document.getElementById("inputStartStudy");
    let inputDateEnd = document.getElementById("inputEndStudy");
    let btnAgregateChangeInEducation = document.getElementById("saveChangesInInputsEducation");
    
    agregateBtnEducation.addEventListener("click", () => {
        showAddFn(inputsToAddEducation);
    });
    
    addInfo(btnAgregateChangeInEducation, inputCareer, inputPlaceStudies, inputDateStart, inputDateEnd, "", "", numberOfListEducation, listItemEducation, inputsToAddEducation, "education");
    
    /*EXPERIENCE: ADD ITEMS*/
    let listInfoExperience = document.getElementsByClassName("list-info-experience");
    let numberOfListExperience = listInfoExperience.length + 1; 
    let agregateBtnExperience = document.getElementById("agregate-btn-experience");
    let inputsToAddExperience = document.getElementById("inputsToAddExperienceInfo");
    let inputJob = document.getElementById("inputJobRole");
    let inputPlaceJob = document.getElementById("inputPlaceJob");
    let inputDateStartJob = document.getElementById("inputStartJob");
    let inputDateEndJob = document.getElementById("inputEndJob");
    let inputTypeJob = document.getElementById("inputJobType");
    let inputSkillsJob = document.getElementById("inputJobSkills");
    let btnAgregateChangeInExperience = document.getElementById("saveChangesInInputsExperience");
    
    agregateBtnExperience.addEventListener("click", () => {
        showAddFn(inputsToAddExperience);
    });
    
    addInfo(btnAgregateChangeInExperience, inputJob, inputPlaceJob, inputDateStartJob, inputDateEndJob, inputTypeJob, inputSkillsJob, numberOfListExperience, listItemExperience, inputsToAddExperience, "jobs");
    
    /*LANGUAGES: ADD ITEMS */
    let listInfoLang = document.getElementsByClassName("list-info-languages");
    let numberOfListLang = listInfoLang.length + 1; 
    let agregateBtnLanguages = document.getElementById("agregate-btn-languages");
    let inputsToAddLangInfo = document.getElementById("inputsToAddLanguageInfo");
    let inputLanguage = document.getElementById("inputLanguage");
    let inputLanguageLevel = document.getElementById("inputLanguageLevel");
    let btnAgregateChangeInLang = document.getElementById("saveChangesInInputsLang");
    
    agregateBtnLanguages.addEventListener("click", () => {
        showAddFn(inputsToAddLangInfo);
    });
    
    addInfo(btnAgregateChangeInLang, inputLanguage, inputLanguageLevel, "","" , "", "", numberOfListLang, listItemLanguage, inputsToAddLangInfo, "langs");    
}

export {AddItems};