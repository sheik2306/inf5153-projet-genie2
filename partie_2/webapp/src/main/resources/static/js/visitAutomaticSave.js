window.onload = () =>{
    
    //SAVING INITIAL DATA FOR CANCEL
    let id = document.getElementById("id").value;
    let initial_select = document.getElementById('institution');
    let initial_institution = initial_select.options[initial_select.selectedIndex].value;
    let initial_doctor = document.getElementById("doctor").value;
    let initial_visitDate= document.getElementById("visitDate").value;
    let initial_diagnostic = document.getElementById("diagnostic").value;
    let initial_treatment = document.getElementById("treatment").value;
    let initial_summary = document.getElementById("summary").value;
    let initial_notes = document.getElementById("notes").value;

    


    //AUTO SAVE
    setInterval(()=>{
      var select = document.getElementById('institution');
      var institution = select.options[select.selectedIndex].value;
      var doctor = document.getElementById("doctor").value;
      var visitDate= document.getElementById("visitDate").value;
      var diagnostic = document.getElementById("diagnostic").value;
      var treatment = document.getElementById("treatment").value;
      var summary = document.getElementById("summary").value;
      var notes = document.getElementById("notes").value;

      var visit = new FormData();
      visit.append("institution", institution);
      visit.append("doctor", doctor);
      visit.append("visitDate",visitDate);
      visit.append("diagnostic",diagnostic );
      visit.append("treatment", treatment);
      visit.append("summary", summary);
      visit.append("notes",notes);

      console.log(JSON.stringify(Object.fromEntries(visit)));
    
      (async () => {
          const rawResponse = await fetch("/api/visits/"+id +"/save", {
            method: 'POST',
            headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            },
            body: JSON.stringify(Object.fromEntries(visit))
            
          });
          const content = await rawResponse.text();
          console.log(content);
        })();
    }, 10000);
        
    // //CANCEL
    document.getElementById("cancel").addEventListener('click', () =>{
      var visit = new FormData();

      visit.append("institution", initial_institution);
      visit.append("doctor", initial_doctor);
      visit.append("visitDate",initial_visitDate);
      visit.append("diagnostic",initial_diagnostic );
      visit.append("treatment", initial_treatment);
      visit.append("summary", initial_summary);
      visit.append("notes",initial_notes);

      console.log(JSON.stringify(Object.fromEntries(visit)));
    
      (async () => {
          const rawResponse = await fetch("/api/visits/"+id +"/cancel", {
            method: 'POST',
            headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            },
            body: JSON.stringify(Object.fromEntries(visit))
            
          });
          const content = await rawResponse.text();
          if(rawResponse.status == 200){
            console.log(content);
            window.location.href= " http://localhost:8888/documents";
          }
        })();
    });

    //SUBMIT
    document.getElementById("submit").addEventListener('click', () => {
      var select = document.getElementById('institution');
      var institution = select.options[select.selectedIndex].value;
      var doctor = document.getElementById("doctor").value;
      var visitDate= document.getElementById("visitDate").value;
      var diagnostic = document.getElementById("diagnostic").value;
      var treatment = document.getElementById("treatment").value;
      var summary = document.getElementById("summary").value;
      var notes = document.getElementById("notes").value;

      var visit = new FormData();
      visit.append("institution", institution);
      visit.append("doctor", doctor);
      visit.append("visitDate",visitDate);
      visit.append("diagnostic",diagnostic );
      visit.append("treatment", treatment);
      visit.append("summary", summary);
      visit.append("notes",notes);

      console.log(JSON.stringify(Object.fromEntries(visit)));
    
      (async () => {
          const rawResponse = await fetch("/api/visits/"+id +"/save", {
            method: 'POST',
            headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            },
            body: JSON.stringify(Object.fromEntries(visit))
            
          });
          const content = await rawResponse.text();
          if(rawResponse.status == 200){
            console.log("submit");
            window.location.href= " http://localhost:8888/documents";
          }
        })();
  });
      
}