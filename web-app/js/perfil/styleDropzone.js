$(function(){ 
  $('#user-profile-1').find('input[type=file]').ace_file_input({
    style:'well',
    btn_choose:'Actualiza tu foto',
    btn_change:null,
    no_icon:'icon-picture',
    thumbnail:'large',
    droppable:true,
    before_change: function(files, dropped) {
      var file = files[0];
      if(typeof file === "string") {//files is just a file name here (in browsers that don't support FileReader API)
        if(! (/\.(jpe?g|png|gif)$/i).test(file) ) return false;
      }
      else {//file is a File object
        var type = $.trim(file.type);
        if( ( type.length > 0 && ! (/^image\/(jpe?g|png|gif)$/i).test(type) )
            || ( type.length == 0 && ! (/\.(jpe?g|png|gif)$/i).test(file.name) )//for android default browser!
          ) return false;
        if( file.size > 110000 ) {//~100Kb
          return false;
        }
      }
      return true;
    }
  })
});
