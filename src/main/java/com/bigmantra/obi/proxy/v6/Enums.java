package com.bigmantra.obi.proxy.v6;

//----------------------------------------------------
//
// Girish Lakshmanan
// 20-03-2017
//
// Oracle BI Serialization Classes
//
//---------------------------------------------------





public class Enums
{

    public enum ItemInfoType
    {
        
        Folder(0),
        
        Link(1),
        
        Object(2),
        
        Missing(3),
        
        NoAccess(4);
        
        private int code;
        
        ItemInfoType(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static ItemInfoType fromString(String str)
        {
            if (str.equals("Folder"))
                return Folder;
            if (str.equals("Link"))
                return Link;
            if (str.equals("Object"))
                return Object;
            if (str.equals("Missing"))
                return Missing;
            if (str.equals("NoAccess"))
                return NoAccess;
		    return null;
        }
    }

    public enum ErrorDetailsLevel
    {
        
        ErrorCode(0),
        
        ErrorCodeAndText(1),
        
        FullDetails(2);
        
        private int code;
        
        ErrorDetailsLevel(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static ErrorDetailsLevel fromString(String str)
        {
            if (str.equals("ErrorCode"))
                return ErrorCode;
            if (str.equals("ErrorCodeAndText"))
                return ErrorCodeAndText;
            if (str.equals("FullDetails"))
                return FullDetails;
		    return null;
        }
    }

    public enum ReadObjectsReturnOptions
    {
        
        NoObject(0),
        
        ObjectAsString(1),
        
        ObjectAsBinary(2),
        
        ObjectAsBinaryUseMtom(3);
        
        private int code;
        
        ReadObjectsReturnOptions(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static ReadObjectsReturnOptions fromString(String str)
        {
            if (str.equals("NoObject"))
                return NoObject;
            if (str.equals("ObjectAsString"))
                return ObjectAsString;
            if (str.equals("ObjectAsBinary"))
                return ObjectAsBinary;
            if (str.equals("ObjectAsBinaryUseMtom"))
                return ObjectAsBinaryUseMtom;
		    return null;
        }
    }

    public enum XMLQueryOutputFormat
    {
        
        SAWRowsetData(0),
        
        SAWRowsetSchema(1),
        
        SAWRowsetSchemaAndData(2);
        
        private int code;
        
        XMLQueryOutputFormat(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static XMLQueryOutputFormat fromString(String str)
        {
            if (str.equals("SAWRowsetData"))
                return SAWRowsetData;
            if (str.equals("SAWRowsetSchema"))
                return SAWRowsetSchema;
            if (str.equals("SAWRowsetSchemaAndData"))
                return SAWRowsetSchemaAndData;
		    return null;
        }
    }

    public enum UpdateACLMode
    {
        
        ReplaceAcl(0),
        
        ReplaceForSpecifiedAccounts(1),
        
        DeleteAccountsFromAcl(2);
        
        private int code;
        
        UpdateACLMode(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static UpdateACLMode fromString(String str)
        {
            if (str.equals("ReplaceAcl"))
                return ReplaceAcl;
            if (str.equals("ReplaceForSpecifiedAccounts"))
                return ReplaceForSpecifiedAccounts;
            if (str.equals("DeleteAccountsFromAcl"))
                return DeleteAccountsFromAcl;
		    return null;
        }
    }

    public enum OverrideType
    {
        
        Default(0),
        
        None(1),
        
        All(2);
        
        private int code;
        
        OverrideType(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static OverrideType fromString(String str)
        {
            if (str.equals("Default"))
                return Default;
            if (str.equals("None"))
                return None;
            if (str.equals("All"))
                return All;
		    return null;
        }
    }

    public enum SATableDetails
    {
        
        Minimum(0),
        
        IncludeColumns(1);
        
        private int code;
        
        SATableDetails(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static SATableDetails fromString(String str)
        {
            if (str.equals("Minimum"))
                return Minimum;
            if (str.equals("IncludeColumns"))
                return IncludeColumns;
		    return null;
        }
    }

    public enum SASubjectAreaDetails
    {
        
        Minimum(0),
        
        IncludeTables(1),
        
        IncludeTablesAndColumns(2);
        
        private int code;
        
        SASubjectAreaDetails(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static SASubjectAreaDetails fromString(String str)
        {
            if (str.equals("Minimum"))
                return Minimum;
            if (str.equals("IncludeTables"))
                return IncludeTables;
            if (str.equals("IncludeTablesAndColumns"))
                return IncludeTablesAndColumns;
		    return null;
        }
    }

    public enum ExportFlags
    {
        
        processAll_ForMerge(0),
        
        processAll_ForReplace(1),
        
        processAll_ForWriteIfNotExists(2),
        
        processLocalChanges(3),
        
        processRemoteChanges(4),
        
        processAllChanges(5);
        
        private int code;
        
        ExportFlags(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static ExportFlags fromString(String str)
        {
            if (str.equals("processAll_ForMerge"))
                return processAll_ForMerge;
            if (str.equals("processAll_ForReplace"))
                return processAll_ForReplace;
            if (str.equals("processAll_ForWriteIfNotExists"))
                return processAll_ForWriteIfNotExists;
            if (str.equals("processLocalChanges"))
                return processLocalChanges;
            if (str.equals("processRemoteChanges"))
                return processRemoteChanges;
            if (str.equals("processAllChanges"))
                return processAllChanges;
		    return null;
        }
    }

    public enum ImportFlags
    {
        
        processLocalChanges(0),
        
        processRemoteChanges(1),
        
        processAllChanges(2);
        
        private int code;
        
        ImportFlags(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static ImportFlags fromString(String str)
        {
            if (str.equals("processLocalChanges"))
                return processLocalChanges;
            if (str.equals("processRemoteChanges"))
                return processRemoteChanges;
            if (str.equals("processAllChanges"))
                return processAllChanges;
		    return null;
        }
    }

    public enum JobStats_jobState
    {
        
        Running(0),
        
        Finished(1),
        
        Error(2),
        
        Queued(3),
        
        Cancelled(4);
        
        private int code;
        
        JobStats_jobState(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static JobStats_jobState fromString(String str)
        {
            if (str.equals("Running"))
                return Running;
            if (str.equals("Finished"))
                return Finished;
            if (str.equals("Error"))
                return Error;
            if (str.equals("Queued"))
                return Queued;
            if (str.equals("Cancelled"))
                return Cancelled;
		    return null;
        }
    }

}