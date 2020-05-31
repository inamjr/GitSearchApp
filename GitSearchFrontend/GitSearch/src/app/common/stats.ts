export class Stats {
  sid: number;
  repoId: number;
  name: string;
  url: string;
  createdDate: string;
  lastPushDate: string;
  description: string;
  numOfStars: number;

  constructor(
    sid: number,
    repoId: number,
    name: string,
    url: string,
    createdDate: string,
    lastPushDate: string,
    description: string,
    numOfStars: number
  ) {
    this.sid = sid;
    this.repoId = repoId;
    this.name = name;
    this.url = url;
    this.createdDate = createdDate;
    this.lastPushDate = lastPushDate;
    this.description = description;
    this.numOfStars = numOfStars;
  }
}
