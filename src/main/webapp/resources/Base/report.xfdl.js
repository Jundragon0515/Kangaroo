(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("report");
            this.set_titletext("New Form");
            if (Form == this.constructor)
            {
                this._setFormPosition(1280,720);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize

            
            // UI Components Initialize
            obj = new Static("Static01","214","139","83","47",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_text("신고사유");
            obj.set_font("normal 13pt/normal \"Arial\"");
            this.addChild(obj.name, obj);

            obj = new Static("Static02","214","201","47","38",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_text("제목");
            obj.set_font("normal 13pt/normal \"Arial\"");
            this.addChild(obj.name, obj);

            obj = new Static("Static03","214","273","52","55",null,null,null,null,null,null,this);
            obj.set_taborder("2");
            obj.set_text("내용");
            obj.set_font("normal 13pt/normal \"Arial\"");
            this.addChild(obj.name, obj);

            obj = new Combo("cause","352","140","168","45",null,null,null,null,null,null,this);
            obj.set_taborder("3");
            obj.set_codecolumn("codecolumn");
            obj.set_datacolumn("datacolumn");
            obj.set_font("normal 13pt/normal \"Arial\"");
            var cause_innerdataset = new nexacro.NormalDataset("cause_innerdataset", obj);
            cause_innerdataset._setContents("<ColumnInfo><Column id=\"codecolumn\" size=\"256\"/><Column id=\"datacolumn\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"codecolumn\">curse</Col><Col id=\"datacolumn\">욕설</Col></Row><Row><Col id=\"codecolumn\">illegality</Col><Col id=\"datacolumn\">불법</Col></Row><Row><Col id=\"codecolumn\">obscene</Col><Col id=\"datacolumn\">음란</Col></Row><Row><Col id=\"codecolumn\">fraud</Col><Col id=\"datacolumn\">사기</Col></Row></Rows>");
            obj.set_innerdataset(cause_innerdataset);
            obj.set_text("");
            this.addChild(obj.name, obj);

            obj = new Edit("title","352","202","337","38",null,null,null,null,null,null,this);
            obj.set_taborder("4");
            obj.set_font("normal 10pt/normal \"Arial\"");
            obj.set_textAlign("left");
            this.addChild(obj.name, obj);

            obj = new TextArea("contents","352","260","337","199",null,null,null,null,null,null,this);
            obj.set_taborder("5");
            obj.set_dragscrolltype("horz");
            obj.set_wordWrap("english");
            obj.set_font("normal 10pt/normal \"Arial\"");
            obj.set_textAlign("left");
            this.addChild(obj.name, obj);

            obj = new Button("Button00","619","473","71","37",null,null,null,null,null,null,this);
            obj.set_taborder("6");
            obj.set_text("신고하기");
            obj.set_font("normal 13pt/normal \"Arial\"");
            this.addChild(obj.name, obj);

            obj = new Static("Static00","210","24","449","98",null,null,null,null,null,null,this);
            obj.set_taborder("7");
            obj.set_text("신고하기");
            obj.set_textAlign("center");
            obj.set_font("normal 30pt/normal \"Arial\"");
            this.addChild(obj.name, obj);

            // Layout Functions
            //-- Default Layout : this
            obj = new Layout("default","",1280,720,this,
            	//-- Layout function
            	function(p)
            	{
                var rootobj = p;
                p = rootobj;
                p.set_titletext("New Form");

                p.Static01.set_taborder("0");
                p.Static01.set_text("신고사유");
                p.Static01.set_font("normal 13pt/normal \"Arial\"");
                p.Static01.move("214","139","83","47",null,null);

                p.Static02.set_taborder("1");
                p.Static02.set_text("제목");
                p.Static02.set_font("normal 13pt/normal \"Arial\"");
                p.Static02.move("214","201","47","38",null,null);

                p.Static03.set_taborder("2");
                p.Static03.set_text("내용");
                p.Static03.set_font("normal 13pt/normal \"Arial\"");
                p.Static03.move("214","273","52","55",null,null);

                p.cause.set_taborder("3");
                p.cause.set_innerdataset(cause_innerdataset);
                p.cause.set_codecolumn("codecolumn");
                p.cause.set_datacolumn("datacolumn");
                p.cause.set_font("normal 13pt/normal \"Arial\"");
                p.cause.set_text("");
                p.cause.move("352","140","168","45",null,null);

                p.title.set_taborder("4");
                p.title.set_font("normal 10pt/normal \"Arial\"");
                p.title.set_textAlign("left");
                p.title.move("352","202","337","38",null,null);

                p.contents.set_taborder("5");
                p.contents.set_dragscrolltype("horz");
                p.contents.set_wordWrap("english");
                p.contents.set_font("normal 10pt/normal \"Arial\"");
                p.contents.set_textAlign("left");
                p.contents.move("352","260","337","199",null,null);

                p.Button00.set_taborder("6");
                p.Button00.set_text("신고하기");
                p.Button00.set_font("normal 13pt/normal \"Arial\"");
                p.Button00.move("619","473","71","37",null,null);

                p.Static00.set_taborder("7");
                p.Static00.set_text("신고하기");
                p.Static00.set_textAlign("center");
                p.Static00.set_font("normal 30pt/normal \"Arial\"");
                p.Static00.move("210","24","449","98",null,null);
            	}
            );
            obj.set_mobileorientation("landscape");
            this.addLayout(obj.name, obj);

            //-- Normal Layout : this
            obj = new Layout("Layout0","",550,500,this,
            	//-- Layout function
            	function(p)
            	{
                var rootobj = p;
                p = rootobj;
                p.Static00.move("50","24","449","98",null,null);

                p.Static01.move("54","139","83","47",null,null);

                p.Static02.move("54","201","47","38",null,null);

                p.Static03.move("54","323","52","55",null,null);

                p.contents.move("162","260","337","189",null,null);

                p.title.move("162","202","337","38",null,null);

                p.cause.move("162","140","168","45",null,null);

                p.Button00.move("429","453","71","37",null,null);
            	}
            );
            obj.set_mobileorientation("landscape");
            this.addLayout(obj.name, obj);
            
            // BindItem Information

        };
        
        this.loadPreloadList = function()
        {

        };
        
        // User Script
        this.registerScript("report.xfdl", function() {

        this.Button00_onclick = function(obj,e)
        {
        	var cause = this.cause.text;
        	var title = this.title.value;
        	var writer = this.writer.value;
        	var contents = this.contents.value;

         		var params = "cause="+cause;
         			params += " title="+title;
         			params += " writer="+writer;
         			params += " contents="+contents;

        	console.log(cause+title+writer+contents);
         			params += " contents="+contents;


        	this.transaction("report","../../report","","",params,"saveCallback");
        };

        this.saveCallback = function(){
        	alert("신고가 접수 되었습니다.");
        	window.close();
        }

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.Static02.addEventHandler("onclick",this.Static02_onclick,this);
            this.title.addEventHandler("onchanged",this.Edit00_onchanged,this);
            this.Button00.addEventHandler("onclick",this.Button00_onclick,this);
            this.Static00.addEventHandler("onclick",this.Static00_onclick,this);
        };

        this.loadIncludeScript("report.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
