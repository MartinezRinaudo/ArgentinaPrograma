function EditItems() {
    function showEditFn(inputsEdit) {
        for (let i = 0; i < inputsEdit.length; i++) {
            if(inputsEdit[i].style.display == "none") {
                inputsEdit[i].style.display = "block";
              } else {
                inputsEdit[i].style.display = "none";
             } 
        }
    }
    
    function editContent(inputsEdit, contents) {
        for (let i = 0; i < inputsEdit.length; i++) {
            if(contents[i] != null) {
                contents[i].innerText = inputsEdit[i].value;
            }
                inputsEdit[i].value = "";
                inputsEdit[i].style.display = "none";     
        };
    }
    /*---------------------PROJECTS: EDIT ITEM-----------------------*/ 
    
    let listInfoProjects = document.getElementsByClassName("list-info-project");
    let btnsEditProject = [];
    let inputsEditProject = [];
    let projectNames = [];
    let projectPlaces = [];
    let projectDescriptions = [];
    let btnSaveChangeEditsProjects = [];
    
    for (let i = 1; i <= listInfoProjects.length; i++) {
        btnsEditProject.push(document.getElementById("edit-btn-projects-"+(i)));
        inputsEditProject.push(document.getElementsByClassName("edit-info-project-"+ (i)));
        projectNames.push(document.getElementById("data-list-project-name-"+(i)));
        projectPlaces.push(document.getElementById("data-list-project-place-"+(i)));
        projectDescriptions.push(document.getElementById("data-list-project-description-"+(i)));
        btnSaveChangeEditsProjects.push(document.getElementById("saveChangesEditedsInProject-"+(i)));
    }
     
    for (let i = 0; i < btnsEditProject.length; i++) {
        
        btnsEditProject[i].addEventListener("click", () => {
            showEditFn(inputsEditProject[i]);
        });
    
        btnSaveChangeEditsProjects[i].addEventListener("click", () => {
            editContent(inputsEditProject[i], [projectNames[i], projectPlaces[i], projectDescriptions[i]]);
        });
    }
    
    /*--------------------EXPERIENCE: EDIT ITEM-----------------*/
    let listInfoExperience = document.getElementsByClassName("list-info-experience");
    let btnsEditExperience = [];
    let inputsEditExperience = [];
    let experienceJobs = [];
    let experiencePlaces = [];
    let experienceStarts = [];
    let experienceEnds = [];
    let experienceTypes = [];
    let experienceSkills = [];
    let btnsSaveChangeEditsJob = [];
    
    for (let i = 1; i <= listInfoExperience.length; i++) {
        btnsEditExperience.push(document.getElementById("edit-btn-experience-"+(i)));
        inputsEditExperience.push(document.getElementsByClassName("edit-info-experience-"+ (i)));
        experienceJobs.push(document.getElementById("data-list-experience-job-"+(i)));
        experiencePlaces.push(document.getElementById("data-list-experience-place-"+(i)));
        experienceStarts.push(document.getElementById("data-list-experience-start-"+(i)));
        experienceEnds.push(document.getElementById("data-list-experience-end-"+(i)));
        experienceTypes.push(document.getElementById("data-list-experience-type-"+(i)));
        experienceSkills.push(document.getElementById("data-list-experience-skills-"+(i)));
        btnsSaveChangeEditsJob.push(document.getElementById("saveChangesEditedsInExperience-"+(i)));
    }
     
    for (let i = 0; i < btnsEditExperience.length; i++) {
        
        btnsEditExperience[i].addEventListener("click", () => {
            showEditFn(inputsEditExperience[i]);
        });
    
        btnsSaveChangeEditsJob[i].addEventListener("click", () => {
            editContent(inputsEditExperience[i], [experienceJobs[i], experiencePlaces[i], experienceStarts[i], experienceEnds[i], experienceTypes[i], experienceSkills[i]]);
        });
    }
    
    /*------------------------EDUCATION: EDIT ITEM---------------------*/
    
    let listInfoEducation = document.getElementsByClassName("list-info-education");
    let btnsEditEducation = [];
    let inputsEditEducation = [];
    let educationNames = [];
    let educationPlaces = [];
    let educationStarts = [];
    let educationEnds = [];
    let btnsSaveChangeEditsEducation = [];
    
    for (let i = 1; i <= listInfoEducation.length; i++) {
        btnsEditEducation.push(document.getElementById("edit-btn-education-"+(i)));
        inputsEditEducation.push(document.getElementsByClassName("edit-info-education-"+ (i)));
        educationNames.push(document.getElementById("data-list-education-name-"+(i)));
        educationPlaces.push(document.getElementById("data-list-education-place-"+(i)));
        educationStarts.push(document.getElementById("data-list-education-start-"+(i)));
        educationEnds.push(document.getElementById("data-list-education-end-"+(i)));
        btnsSaveChangeEditsEducation.push(document.getElementById("saveChangesEditedsInEducation-"+(i)));
    }
     
    for (let i = 0; i < btnsEditEducation.length; i++) {
        
        btnsEditEducation[i].addEventListener("click", () => {
            showEditFn(inputsEditEducation[i]);
        });
    
        btnsSaveChangeEditsEducation[i].addEventListener("click", () => {
            editContent(inputsEditEducation[i], [educationNames[i], educationPlaces[i], educationStarts[i], educationEnds[i]]);
        });
    }
    /*--------------LANGUAGES: EDIT ITEM-------------- */
    let listInfoLanguage = document.getElementsByClassName("list-info-languages");
    let btnsEditLanguage = [];
    let inputsEditLanguage = [];
    let languagesLang = [];
    let btnsSaveChangeEditsLang = [];
    
    for (let i = 1; i <= listInfoLanguage.length; i++) {
        btnsEditLanguage.push(document.getElementById("edit-btn-languages-"+(i)));
        inputsEditLanguage.push(document.getElementsByClassName("edit-info-language-"+ (i)));
        languagesLang.push(document.getElementById("data-list-languages-lang-"+(i)));
        btnsSaveChangeEditsLang.push(document.getElementById("saveChangesEditedsInLanguages-"+(i)));
    }
     
    for (let i = 0; i < btnsEditLanguage.length; i++) {
        
        btnsEditLanguage[i].addEventListener("click", () => {
            showEditFn(inputsEditLanguage[i]);
        });
    
        btnsSaveChangeEditsLang[i].addEventListener("click", () => {
            editContent(inputsEditLanguage[i], [languagesLang[i]]);
        });
    }   
}

export { EditItems};